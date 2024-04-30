package com.hotel.hotelmanagement.dto;

import com.hotel.hotelmanagement.entity.Hotel;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class RoomDto {


        private Integer id;

        private String roomNumber;

        private String roomType;

    }
