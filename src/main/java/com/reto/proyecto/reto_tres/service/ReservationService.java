package com.reto.proyecto.reto_tres.service;



import com.reto.proyecto.reto_tres.entities.Reservation;
import com.reto.proyecto.reto_tres.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (e.isEmpty()){
                return reservationRepository.save(reservation);
            }else {
                return reservation;
            }
        }
    }

      

}
     