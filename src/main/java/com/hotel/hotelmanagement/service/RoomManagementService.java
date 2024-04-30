package com.hotel.hotelmanagement.service;

import com.hotel.hotelmanagement.dto.HotelRoomDto;
import com.hotel.hotelmanagement.entity.Room;
import com.hotel.hotelmanagement.mapper.HotelRoomDtoMapper;
import com.hotel.hotelmanagement.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomManagementService {
    private RoomRepository roomRepository;


    public HotelRoomDto getRooms(Long hotelId) {
        List<Room> hotels = roomRepository.findByHotelHotelId(hotelId);
        return HotelRoomDtoMapper.hotelRoomDtoMapper(hotels);
    }

    public HotelRoomDto getRoom(Long hotelId, Integer roomId) {
        System.out.println("******************************");
        Room byIdAndHotelHotelId = roomRepository.findByIdAndHotelHotelId(roomId, hotelId);
        return HotelRoomDtoMapper.hotelRoomDtoMapper(byIdAndHotelHotelId);
    }

    public Room createRoom(Long hotelId, Room room) {
        System.out.println("*****************");
        return roomRepository.save(room);
    }

    @Transactional
    public String deleteRoom(Long hotelId, String roomNumber) {
        System.out.println("************************************");
       if(!roomRepository.findByRoomNumberAndHotelHotelId(roomNumber, hotelId).isEmpty()){
        roomRepository.deleteByRoomNumberAndHotelHotelId(roomNumber , hotelId);
        return "Given Room Number "+roomNumber +" removed from Hotel ";
    }
       else {
       return "Given room number not linked with given hotel";}
    }
}
