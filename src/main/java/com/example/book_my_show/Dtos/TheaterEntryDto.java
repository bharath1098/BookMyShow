package com.example.book_my_show.Dtos;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TheaterEntryDto {
    private String theaterName;
    private String location;
    private int classicSeatCount;
    private int premiumSeatCount;

}
