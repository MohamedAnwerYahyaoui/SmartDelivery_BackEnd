package tn.esprit.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.client.Entity.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Client findClientByNom(String nom);
}
