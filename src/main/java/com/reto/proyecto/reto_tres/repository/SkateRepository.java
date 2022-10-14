package com.reto.proyecto.reto_tres.repository;

import com.reto.proyecto.reto_tres.entities.Skate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reto.proyecto.reto_tres.repository.crudRepository.SkateCrudRepository;


@Repository
public class SkateRepository {
    
    @Autowired
    private SkateCrudRepository skateCrudRepository;

    public List<Skate> getAll(){
        return (List<Skate>) skateCrudRepository.findAll();
    }

    public Skate save(Skate skate){
        return skateCrudRepository.save(skate);
    }
    public Optional<Skate> getSkate(int id){
        return skateCrudRepository.findById(id);
    }
    
    public void delete(Skate skate){
        skateCrudRepository.delete(skate);
    }

    
    
}
