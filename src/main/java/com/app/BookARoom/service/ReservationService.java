package com.app.BookARoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BookARoom.dao.Reservation;
import com.app.BookARoom.repo.ReservationRepository;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService( ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    public Reservation addReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
}
