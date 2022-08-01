package models;

import entities.Aluno;
import entities.Endereco;
import entities.Telefone;
import org.hibernate.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(aluno);
            for (Endereco endereco: aluno.getEnderecos()) {
                em.persist(endereco);
            }
            for(Telefone telefone: aluno.getTelefones()){
                em.persist(telefone);
            }
            em.flush();
            em.clear();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Erro ao criar o aluno !!!" + e.getMessage());
            throw new Exception();
        } finally {
            em.close();
        }
    }

    public void update(Aluno aluno) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Session session = em.unwrap(Session.class);
            session.update(aluno);
            session.clear();
            session.close();

        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar o aluno !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Aluno aluno) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Erro ao deletar o aluno !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Aluno findById(Long id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Aluno aluno = em.find(Aluno.class, id);
            return aluno;

        } catch (Exception e) {
            System.err.println("Erro ao buscar o aluno !!!" + e.getMessage());
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }

    public List<Aluno> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Session session = em.unwrap(Session.class);
            return session.createQuery("SELECT DISTINCT l FROM Aluno l INNER JOIN l.telefones t INNER JOIN l.enderecos e", Aluno.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar a tabela !!!" + e.getMessage());
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }
}