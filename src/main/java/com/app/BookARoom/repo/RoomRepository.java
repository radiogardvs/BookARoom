package com.app.BookARoom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.BookARoom.dao.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
}
