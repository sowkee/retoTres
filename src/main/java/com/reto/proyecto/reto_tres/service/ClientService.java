package com.reto.proyecto.reto_tres.service;


import com.reto.proyecto.reto_tres.entities.Client;
import com.reto.proyecto.reto_tres.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (e.isEmpty()){
                return clientRepository.save(client);
            }else {
                return client;
            }
        }
    }

     

}
     