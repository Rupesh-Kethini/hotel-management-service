package com.hotel.hotelmanagement.repository;

import com.hotel.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByHotelHotelId(Long hotelId);

    Room findByIdAndHotelHotelId(Integer roomId, Long hotelId);
    List<Room> findByRoomNumberAndHotelHotelId(String roomNumber, Long hotelId);

    void deleteByRoomNumberAndHotelHotelId(String roomNumber, Long hotel_hotelId);
}