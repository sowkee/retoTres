package com.reto.proyecto.reto_tres.repository.crudRepository;


import com.reto.proyecto.reto_tres.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    @Query("SELECT s.skate, COUNT (s.skate) FROM Reservation AS s GROUP BY s.skate ORDER BY COUNT(s.skate) DESC")
    public List<Object[]> countTotalReservationBySkate();
    
    @Query("SELECT c.client, COUNT (c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
    
    //SELECT * from Reservation where tartDate AFTER fechaInicio AND devolutionDate Before FEchaFin ; 
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore (Date dateOne, Date dateTwo);
    
    //SELECT * FROM Reservation where status 'cancelled' 
    public List<Reservation> findAllByStatus(String staus);
}
