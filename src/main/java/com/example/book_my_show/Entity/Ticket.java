package com.example.book_my_show.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String ticketId= UUID.randomUUID().toString();
    private String theaterName;
    private String bookedSeat;

    //ticket is child wrt to user
    @ManyToOne
    @JoinColumn
    private User user;

    //ticket is child wrt to show
    @ManyToOne
    @JoinColumn
    private Show show;
}
