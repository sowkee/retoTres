package com.reto.proyecto.reto_tres.repository.crudRepository;


import com.reto.proyecto.reto_tres.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
