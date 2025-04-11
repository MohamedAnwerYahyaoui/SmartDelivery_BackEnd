package tn.esprit.client;

import org.springframework.stereotype.Service;
import tn.esprit.client.Entity.Client;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {




    private ClientRepo cr;



    public ClientService(ClientRepo cr){
        this.cr=cr;

    }



    public Client ajouterClient(Client client) {
        return cr.save(client);
    }


    public List<Client> findAll() {
        return cr.findAll();
    }


    public Client updateClient(long id, Client newclient) {
        if (cr.findById(id).isPresent()) {
            Client client = cr.findById(id).get();
            client.setAdresse(newclient.getAdresse());
            client.setNom(newclient.getNom());
            client.setMail(newclient.getMail());
            return cr.save(client);
        } else
            return null;
    }


    public String deleteClient(long id) {
        if (cr.findById(id).isPresent()) {
            cr.deleteById(id);
            return "client supprimé";
        } else
            return "client non supprimé";
    }





    public Client findBynom(String nom){
        return cr.findClientByNom(nom);
    }


    public Client findById(Long id){
        return cr.findById(id).get();
    }
























}
