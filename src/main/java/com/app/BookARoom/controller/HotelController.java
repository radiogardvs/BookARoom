package com.app.BookARoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.BookARoom.dao.Hotel;
import com.app.BookARoom.dao.Room;
import com.app.BookARoom.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }
    @GetMapping("/allinrange")
    public ResponseEntity<List<Hotel>> getAllHotelsInRange() {
        return new ResponseEntity<>(hotelService.getHotelsInRange(40.17, 27.57, 100000), HttpStatus.OK);
    }
     @GetMapping("/{hotelId}/rooms")
    public ResponseEntity<List<Room>> getRoomsByHotelId(@PathVariable Long hotelId) {
        List<Room> rooms = hotelService.getRoomsByHotelId(hotelId);
        return ResponseEntity.ok(rooms);
    }
    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.OK);
    } 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable("id") Long id) {
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
