package com.hotel.hotelmanagement.dto;

import com.hotel.hotelmanagement.entity.Hotel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class HotelRoomDto {
        private String hotelName;
        private String placeOfHotel;
        private String hotelDetails;
        private List<RoomDto> room;


    }

