package com.reto.proyecto.reto_tres.repository;

import com.reto.proyecto.reto_tres.entities.Client;
import com.reto.proyecto.reto_tres.repository.crudRepository.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }


    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    
}
