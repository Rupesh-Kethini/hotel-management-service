package com.hotel.hotelmanagement.mapper;

import com.hotel.hotelmanagement.dto.HotelRoomDto;
import com.hotel.hotelmanagement.dto.RoomDto;
import com.hotel.hotelmanagement.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelRoomDtoMapper {

    public static HotelRoomDto hotelRoomDtoMapper(List<Room> rooms ){
        HotelRoomDto hotelRoomDto = new HotelRoomDto();
        hotelRoomDto.setHotelName(rooms.get(0).getHotel().getName());
        hotelRoomDto.setPlaceOfHotel(rooms.get(0).getHotel().getLocation());
        hotelRoomDto.setHotelDetails(rooms.get(0).getHotel().getDescription());
        List<RoomDto> ListOfroomInHotel = rooms.stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setId(room.getId());
            roomDto.setRoomType(room.getRoomType());
            roomDto.setRoomNumber(room.getRoomNumber());
            return roomDto;
        }).toList();
        hotelRoomDto.setRoom(ListOfroomInHotel);
        return hotelRoomDto;
    }

    public static HotelRoomDto hotelRoomDtoMapper(Room room ){
        HotelRoomDto hotelRoomDto = new HotelRoomDto();
        hotelRoomDto.setHotelName(room.getHotel().getName());
        hotelRoomDto.setPlaceOfHotel(room.getHotel().getLocation());
        hotelRoomDto.setHotelDetails(room.getHotel().getDescription());
        RoomDto roomDto = new RoomDto();
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDto.setId(room.getId());
        roomDto.setRoomType(room.getRoomType());
        roomDto.setRoomNumber(room.getRoomNumber());
        roomDtoList.add(roomDto);
        hotelRoomDto.setRoom(roomDtoList);
        return hotelRoomDto;
    }
}
