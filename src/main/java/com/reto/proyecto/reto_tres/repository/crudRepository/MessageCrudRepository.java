package com.reto.proyecto.reto_tres.repository.crudRepository;


import com.reto.proyecto.reto_tres.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
