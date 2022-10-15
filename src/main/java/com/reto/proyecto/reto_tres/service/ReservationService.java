package com.reto.proyecto.reto_tres.service;



import com.reto.proyecto.reto_tres.entities.DTOs.CountClient;
import com.reto.proyecto.reto_tres.entities.DTOs.CountStatus;
import com.reto.proyecto.reto_tres.entities.Reservation;
import com.reto.proyecto.reto_tres.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    
    
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }
    
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a  = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException exception) {
            exception.printStackTrace();
        }
        
        if (a.before(b)){
            return reservationRepository.getReservationPeriod(a, b);
        }else {
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationStatus(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        
        return new CountStatus((long) completed.size(), (long)cancelled.size());
        
    }

}
     