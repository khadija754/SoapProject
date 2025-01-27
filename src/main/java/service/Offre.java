package service;
import javax.xml.bind.annotation.XmlType;
@XmlType

public class Offre {
    private String id;
    private String description;
    private String roleRecherche;

    public Offre() {}

    // Constructeur
    public Offre(String id, String description, String roleRecherche) {
        this.id = id;
        this.description = description;
        this.roleRecherche = roleRecherche;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleRecherche() {
        return roleRecherche;
    }

    public void setRoleRecherche(String roleRecherche) {
        this.roleRecherche = roleRecherche;
    }
}