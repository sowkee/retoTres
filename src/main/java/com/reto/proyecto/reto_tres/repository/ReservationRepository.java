package com.reto.proyecto.reto_tres.repository;


import com.reto.proyecto.reto_tres.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reto.proyecto.reto_tres.repository.crudRepository.MessageCrudRepository;
import com.reto.proyecto.reto_tres.repository.crudRepository.ReservationCrudRepository;


@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    
}
