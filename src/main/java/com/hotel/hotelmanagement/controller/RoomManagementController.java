package com.hotel.hotelmanagement.controller;

import com.hotel.hotelmanagement.dto.HotelRoomDto;
import com.hotel.hotelmanagement.entity.Room;
import com.hotel.hotelmanagement.service.RoomManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoomManagementController {
    private RoomManagementService roomManagementService;

    @GetMapping("/hotels/{hotelId}/rooms")
    public ResponseEntity<HotelRoomDto> getAllRooms(@PathVariable Long hotelId){
        HotelRoomDto rooms = roomManagementService.getRooms(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);

    }

    @GetMapping("/hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<HotelRoomDto> getAllRooms(@PathVariable Long hotelId ,
                                                    @PathVariable Integer roomId){
        HotelRoomDto rooms = roomManagementService.getRoom(hotelId , roomId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);

    }

    @PostMapping("/hotels/{hotelId}/rooms")
    public ResponseEntity<Room> createRoom(@PathVariable Long hotelId,
                                                    @RequestBody Room room){
        Room rooms = roomManagementService.createRoom(hotelId , room);
        return new ResponseEntity<>(rooms, HttpStatus.OK);

    }

    @DeleteMapping("/hotels/{hotelId}/rooms/{roomNumber}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long hotelId ,
                                                    @PathVariable String roomNumber){
        String msg =roomManagementService.deleteRoom(hotelId , roomNumber);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
