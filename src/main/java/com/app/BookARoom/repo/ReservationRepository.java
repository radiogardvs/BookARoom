package com.app.BookARoom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.BookARoom.dao.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
