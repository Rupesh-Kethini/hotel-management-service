package com.hotel.hotelmanagement.service;

import com.hotel.hotelmanagement.entity.Hotel;
import com.hotel.hotelmanagement.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelManagementService {
    private HotelRepository hotelRepository;
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotel(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow();
    }

    public Hotel addHotel(Hotel hotel) {
       return hotelRepository.save(hotel);
    }

    public String deleteHotel(Long hotelId) {
        if (hotelRepository.findById(hotelId).isPresent()) {
            hotelRepository.deleteById(hotelId);
            return "Hotel details has been removed from website";
        }
        else {
            return "Given Hotel ID is not Listed in website";
        }
    }
}
