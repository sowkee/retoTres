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
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                
                return e.get();
            }else{
                
                return client;
            }
        }else{
            
            return client;
        }
    }
    
    public boolean delete(int clientId) {
        boolean flag=false;
        Optional<Client> c= clientRepository.getClient(clientId);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
    
}
     


     