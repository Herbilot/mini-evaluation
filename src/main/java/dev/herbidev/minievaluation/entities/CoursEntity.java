package dev.herbidev.minievaluation.entities;


import javax.persistence.*;

@Entity
@Table(name = "cours")
public class CoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matiere")
    private String matiere;

    @Column(name = "professeur")
    private String professeur;

    @Column(name = "classe")
    private String classe;

    public CoursEntity() {
    }

    public CoursEntity(Long id, String matiere, String professeur, String classe) {
        this.id = id;
        this.matiere = matiere;
        this.professeur = professeur;
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}