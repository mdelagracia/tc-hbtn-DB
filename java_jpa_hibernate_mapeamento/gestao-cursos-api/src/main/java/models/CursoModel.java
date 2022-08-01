package models;

import entities.Curso;
import org.hibernate.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {

    public void create(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.persist(curso.getMaterialCurso());
            em.persist(curso.getProfessor());
            em.flush();
            em.clear();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Erro ao criar o curso !!!" + e.getMessage());
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }

    public void update(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Session session = em.unwrap(Session.class);
            session.update(curso);
            session.clear();
            session.close();

        } catch (Exception e) {
            System.err.println("Erro ao atualizar o curso !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(curso);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Erro ao deletar o curso !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Curso findById(Long id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Curso curso = em.find(Curso.class, id);
            return curso;

        } catch (Exception e) {
            System.err.println("Erro ao buscar o curso !!!" + e.getMessage());
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }

    public List<Curso> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Session session = em.unwrap(Session.class);
            return session.createQuery("SELECT DISTINCT c FROM Curso c INNER JOIN c.professor p INNER JOIN c.materialCurso m", Curso.class).getResultList();

        } catch (Exception e) {
            System.err.println("Erro ao procurar a tabela !!!" + e.getMessage());
            throw new RuntimeException();
        } finally {
            em.close();
        }
    }
}