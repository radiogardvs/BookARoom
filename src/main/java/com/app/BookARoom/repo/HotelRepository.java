package com.app.BookARoom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.BookARoom.dao.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
}
