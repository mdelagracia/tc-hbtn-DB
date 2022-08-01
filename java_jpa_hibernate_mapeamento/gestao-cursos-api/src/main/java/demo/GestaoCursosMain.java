package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) throws Exception {
        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();

        Professor professor = new Professor();
        professor.setNomeCompleto("Neri");
        professor.setMatricula("34234");
        professor.setEmail("neri@email.com");

        Curso curso = new Curso();
        curso.setNome("CorelDraw");
        curso.setProfessor(professor);
        curso.setSigla("CCD");

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Josias");
        aluno.setMatricula("342234");
        aluno.setNascimento(new Date(20 / 02 / 2000));
        aluno.setEmail("josias@email.com");

        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("35640897");
        telefone.setAluno(aluno);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua");
        endereco.setEndereco("das Flores");
        endereco.setNumero("32");
        endereco.setBairro("Amoreiras");
        endereco.setCidade("Blumenau");
        endereco.setEstado("Santa Catarina");
        endereco.setCep(34214 - 678);
        endereco.setAluno(aluno);

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        aluno.setEnderecos(enderecos);

        List<Telefone> telefones = new ArrayList<>();
        telefones.add(telefone);
        aluno.setTelefones(telefones);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        curso.setAlunos(alunos);

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("www.neri.com.br");
        materialCurso.setCurso(curso);

        curso.setMateriaisCurso(materialCurso);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso);
        professor.setCursos(cursos);
        aluno.setCursos(cursos);

        alunoModel.create(aluno);
        cursoModel.create(curso);


       curso.setAlunos(alunos);
       cursoModel.update(curso);

       aluno.setCursos(cursos);
       alunoModel.update(aluno);

        alunoModel.delete(aluno);

        Aluno result1 = alunoModel.findById(1l);
        System.out.println(result1.getNomeCompleto());

        Curso result2 = cursoModel.findById(1l);
        System.out.println(result2.getNome());

        List<Aluno> alunos1 = alunoModel.findAll();
        for(Aluno aluno1: alunos1){
            System.out.println(aluno1.getId());
        }

        List<Curso> lista = cursoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + lista.size());
        for (Curso item: lista) {
             System.out.println(item.getId());
        }
    }
}
