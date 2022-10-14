package com.reto.proyecto.reto_tres.repository.crudRepository;



import com.reto.proyecto.reto_tres.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
    
}
