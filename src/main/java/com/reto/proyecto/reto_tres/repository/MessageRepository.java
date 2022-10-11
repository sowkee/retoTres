package com.reto.proyecto.reto_tres.repository;

import com.reto.proyecto.reto_tres.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reto.proyecto.reto_tres.repository.crudRepository.MessageCrudRepository;


@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    
}
