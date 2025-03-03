package tn.esprit.Fournisseur.Service;

import org.springframework.stereotype.Service;
import tn.esprit.Fournisseur.Entity.Fournisseur;
import tn.esprit.Fournisseur.Repository.FournisseurRepository;

import java.util.List;

@Service
public class FournisseurService {
    private FournisseurRepository fr;

    public FournisseurService(FournisseurRepository fr){
        this.fr=fr;
    }



    public Fournisseur ajouterFournisseur(Fournisseur fournisseur ) {
        return fr.save(fournisseur);
    }


    public List<Fournisseur> findAll() {
        return fr.findAll();
    }


    public Fournisseur updateFournisseur(long id, Fournisseur newFournisseur) {
        if (fr.findById(id).isPresent()) {
            Fournisseur fournisseur = fr.findById(id).get();
            fournisseur.setNomFournisseur(newFournisseur.getNomFournisseur());
            fournisseur.setAdresse(newFournisseur.getAdresse());
            fournisseur.setNumtel(newFournisseur.getNumtel());
            return fr.save(fournisseur);
        } else
            return null;
    }


    public String deleteFournisseur(long id) {
        if (fr.findById(id).isPresent()) {
            fr.deleteById(id);
            return "Fournisseur supprimé";
        } else
            return "Fournisseur non supprimé";
    }
}
