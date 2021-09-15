package lp2.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import lp2.model.entities.Client;

public interface ClientRepository extends MongoRepository<Client, String>{

    boolean existsByName(String n);
    Client findByName(String n);
}