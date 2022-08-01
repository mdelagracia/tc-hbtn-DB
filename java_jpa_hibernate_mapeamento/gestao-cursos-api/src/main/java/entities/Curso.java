package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue
    @Column(name="curso_id")
    private Long id;
    private String nome;
    private String sigla;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    @OneToOne
    @JoinColumn(name="materialCurso_id")
    private MaterialCurso materialCurso;

    @ManyToMany
    @JoinTable(
            name = "Fk_Curso_Aluno",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public MaterialCurso getMaterialCurso() {
        return materialCurso;
    }

    public void setMateriaisCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}