/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Reservation;
import co.usa.ciclo3.reto34.reto34.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */
@Service
public class ServiceReservation {
    @Autowired
    private ReservationRepository reservationService;
	
    public List<Reservation> getAll(){
	return reservationService.getAll();
    }
	
    public Optional<Reservation> getReservation(int idReservation) {
	return reservationService.getReservation(idReservation);
    }
    public Reservation save(Reservation reservation){
	if(reservation.getIdReservation()==null){
	    return reservationService.save(reservation);
	}else{
	    Optional<Reservation> reservationAux=reservationService.getReservation(reservation.getIdReservation());
	    if(reservationAux.isEmpty()){
	        return reservationService.save(reservation);
	    }else{
	        return reservation;
                 }
            }
    }
	
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> reservationAux= reservationService.getReservation(reservation.getIdReservation());
            if(!reservationAux.isEmpty()){
                if(reservation.getStartDate()!=null){
                    reservationAux.get().setStartDate(reservation.getStartDate());     
                }
                if(reservation.getDevolutionDate()!=null){
                    reservationAux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    reservationAux.get().setStatus(reservation.getStatus());      
                }
                reservationService.save(reservationAux.get());
                return reservationAux.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean delete(int idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            reservationService.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
