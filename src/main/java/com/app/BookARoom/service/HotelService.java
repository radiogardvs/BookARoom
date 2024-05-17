package com.app.BookARoom.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.BookARoom.dao.Feedback;
import com.app.BookARoom.dao.Hotel;
import com.app.BookARoom.dao.Room;
import com.app.BookARoom.repo.HotelRepository;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    @Autowired
    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
    public List<Hotel> getHotelsInRange(double currentLat, double currentLon, int rangeKm){
         return hotelRepository.findAll().stream()
                .filter(hotel -> calculateDistance(currentLat, currentLon, hotel.getLatitude(), hotel.getLongitude()) <= rangeKm)
                .collect(Collectors.toList());
    }
     public List<Room> getRoomsByHotelId(Long hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            return hotel.getRooms();
        }
        return Collections.emptyList();
    }
    public List<Feedback> getFeedbacksByHotelId(Long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            return hotel.getFeedbacks();
        } 
        return Collections.emptyList();
    }
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double EARTH_RADIUS = 6371.0;
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
