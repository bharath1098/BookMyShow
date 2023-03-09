package com.example.book_my_show.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="theater")
@Builder
@AllArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String theaterName;
    private String location;

    //theater is parent wrt to show
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> showList=new ArrayList<>();

    //theater is parent wrt theaterSeat
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeats> theaterSeatsList=new ArrayList<>();
}
