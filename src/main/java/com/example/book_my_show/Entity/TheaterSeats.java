package com.example.book_my_show.Entity;

import com.example.book_my_show.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="theaterSeats")
public class TheaterSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private SeatType seatType;
    private String seatNo;

    // theaterseat is child wrt theater
    @ManyToOne
    @JoinColumn
    private Theater theater;

}
