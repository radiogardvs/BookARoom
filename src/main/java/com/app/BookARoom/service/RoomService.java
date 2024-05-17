package com.app.BookARoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BookARoom.dao.Room;
import com.app.BookARoom.repo.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
