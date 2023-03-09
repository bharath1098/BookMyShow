package com.example.book_my_show.Entity;

import com.example.book_my_show.Enum.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="showSeats")
public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;
    private int price;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    @CreationTimestamp
    private Date bookedAt;

    //showSeats is child wrt show
    @ManyToOne
    @JoinColumn
    private Show show;
}
