package service;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Candidat {
    private String id;
    private String nom;
    private String role;

    public Candidat() {}

    // Constructeur
    public Candidat(String id, String profil, String role) {
        this.id = id;
        this.nom = profil;
        this.role = role;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfil() {
        return nom;
    }

    public void setProfil(String profil) {
        this.nom = profil;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
