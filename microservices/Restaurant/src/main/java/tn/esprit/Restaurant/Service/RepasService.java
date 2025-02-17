package tn.esprit.Restaurant.Service;

import org.springframework.stereotype.Service;
import tn.esprit.Restaurant.Repository.RepasRepository;
import tn.esprit.Restaurant.entity.Restaurant;
import tn.esprit.Restaurant.entity.repas;

import java.util.List;

@Service
public class RepasService {

    private final RepasRepository rr;

    public RepasService(RepasRepository rr){
        this.rr=rr;
    }

    public repas ajouterRepas(repas r) {
        return rr.save(r);
    }


    public List<repas> findAll() {
        return rr.findAll();
    }


    public repas updateRepas(long id, repas newRepas) {
        if (rr.findById(id).isPresent()) {
            repas re = rr.findById(id).get();
            re.setNom(newRepas.getNom());
            re.setDesc(newRepas.getDesc());
            re.setPrix(newRepas.getPrix());


            return rr.save(re);
        } else
            return null;
    }


    public String deleteRepas(long id) {
        if (rr.findById(id).isPresent()) {
            rr.deleteById(id);
            return "Repas supprimé";
        } else
            return "Repas non supprimé";
    }




}
