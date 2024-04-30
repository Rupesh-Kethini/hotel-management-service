package com.hotel.hotelmanagement.controller;

import com.hotel.hotelmanagement.entity.Hotel;
import com.hotel.hotelmanagement.service.HotelManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelManagementController {
    private HotelManagementService hotelManagementService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelManagementService.getAllHotels();
        return new ResponseEntity<>(allHotels , HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long hotelId){
        Hotel hotel = hotelManagementService.getHotel(hotelId);
        return new ResponseEntity<>(hotel , HttpStatus.OK);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> addHotel(@PathVariable Long hotelId,//currently this variable has no use
                                           @RequestBody Hotel hotel ){
        Hotel updatedHotel = hotelManagementService.addHotel(hotel);
        return new ResponseEntity<>(updatedHotel, HttpStatus.ACCEPTED);
    }
    @PostMapping()
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel ){
        Hotel addedHotel = hotelManagementService.addHotel(hotel);
        return new ResponseEntity<>(addedHotel, HttpStatus.CREATED);
    }
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long hotelId){

        String message = hotelManagementService.deleteHotel(hotelId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
