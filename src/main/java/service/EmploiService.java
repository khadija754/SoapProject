package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebService(serviceName = "BureauDemploiWS")
public class EmploiService {
    private final HashMap<String, List<Candidat>> candidats = new HashMap<>();
    private final HashMap<String, List<Offre>> offres = new HashMap<>();

    // Méthodes pour les candidats

    @WebMethod(operationName = "ajouterCandidat")
    public String ajouterCandidat(@WebParam(name = "id") String id,
                                  @WebParam(name = "profil") String profil,
                                  @WebParam(name = "role") String role) {
        Candidat candidat = new Candidat(id, profil, role);
        candidats.putIfAbsent(role, new ArrayList<>());

        for (Candidat c : candidats.get(role)) {
            if (c.getId().equals(id)) {
                return "Un candidat avec cet ID existe déjà.";
            }
        }

        candidats.get(role).add(candidat);
        return "Candidat ajouté avec succès.";
    }

    @WebMethod(operationName = "mettreAJourCandidat")
    public String mettreAJourCandidat(@WebParam(name = "id") String id,
                                      @WebParam(name = "nouveauProfil") String nouveauProfil) {
        for (List<Candidat> listeCandidats : candidats.values()) {
            for (Candidat c : listeCandidats) {
                if (c.getId().equals(id)) {
                    c.setRole(nouveauProfil);
                    return "Profil du candidat mis à jour avec succès.";
                }
            }
        }
        return "Candidat non trouvé.";
    }

    @WebMethod(operationName = "supprimerCandidat")
    public String supprimerCandidat(@WebParam(name = "id") String id) {
        for (List<Candidat> listeCandidats : candidats.values()) {
            if (listeCandidats.removeIf(c -> c.getId().equals(id))) {
                return "Candidat supprimé avec succès.";
            }
        }
        return "Candidat non trouvé.";
    }

    @WebMethod(operationName = "rechercherCandidats")
    public List<Candidat> rechercherCandidatsParRole(@WebParam(name = "role") String role) {
        return candidats.getOrDefault(role, new ArrayList<>());
    }

    // Méthodes pour les offres

    @WebMethod(operationName = "ajouterOffre")
    public String ajouterOffre(@WebParam(name = "id") String id,
                               @WebParam(name = "description") String description,
                               @WebParam(name = "roleRecherche") String roleRecherche) {
        Offre offre = new Offre(id, description, roleRecherche);
        offres.putIfAbsent(roleRecherche, new ArrayList<>());

        for (Offre o : offres.get(roleRecherche)) {
            if (o.getId().equals(id)) {
                return "Une offre avec cet ID existe déjà.";
            }
        }

        offres.get(roleRecherche).add(offre);
        return "Offre ajoutée avec succès.";
    }

    @WebMethod(operationName = "rechercherOffre")
    public Offre rechercherOffreParId(@WebParam(name = "id") String id) {
        for (List<Offre> listeOffres : offres.values()) {
            for (Offre o : listeOffres) {
                if (o.getId().equals(id)) {
                    return o;
                }
            }
        }
        return null; // Si aucune offre n'est trouvée
    }

    @WebMethod(operationName = "supprimerOffre")
    public String supprimerOffre(@WebParam(name = "id") String id) {
        for (List<Offre> listeOffres : offres.values()) {
            if (listeOffres.removeIf(o -> o.getId().equals(id))) {
                return "Offre supprimée avec succès.";
            }
        }
        return "Offre non trouvée.";
    }
}
