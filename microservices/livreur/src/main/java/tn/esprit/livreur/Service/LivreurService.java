package tn.esprit.livreur.Service;

import org.springframework.stereotype.Service;
import tn.esprit.livreur.Repo.LivreurRepo;
import tn.esprit.livreur.entity.Livreur;
import tn.esprit.livreur.openfeign.LocalisationDTO;
import tn.esprit.livreur.openfeign.RestaurantLocatorClient;

import java.util.List;
@Service
public class LivreurService {
    private LivreurRepo fr;
    private RestaurantLocatorClient locatorClient;
    public LivreurService(LivreurRepo fr,RestaurantLocatorClient locatorClient){
        this.fr=fr;
        this.locatorClient=locatorClient;
    }

    public LocalisationDTO rechercherLocalisationParNom(String nomRestaurant) {
        return locatorClient.getLocalisation(nomRestaurant);
    }

    public Livreur ajouterLivreur(Livreur livreur ) {
        return fr.save(livreur);
    }
    public Livreur findById(Long id ) {
        return fr.findById(id).get();
    }


    public List<Livreur> findAll() {
        return fr.findAll();
    }


    public Livreur updateLivreur(long id, Livreur newLivr) {
        if (fr.findById(id).isPresent()) {
            Livreur livreur = fr.findById(id).get();
            livreur.setNomLiv(newLivr.getNomLiv());
            livreur.setAdresse(newLivr.getAdresse());
            livreur.setEmail(newLivr.getEmail());
            return fr.save(livreur);
        } else
            return null;
    }


    public String deleteLivreur(long id) {
        if (fr.findById(id).isPresent()) {
            fr.deleteById(id);
            return "Livreur supprimé";
        } else
            return "Livreur non supprimé";
    }
}
