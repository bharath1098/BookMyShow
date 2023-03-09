package com.example.book_my_show.Dtos;

import com.example.book_my_show.Entity.ShowSeats;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class TicketEntryDto {

    private int userId;
    private List<String> requestedSeat=new ArrayList<>();
    private int showId;
}
