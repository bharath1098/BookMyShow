package com.example.book_my_show.Entity;

import com.example.book_my_show.Enum.Genre;
import com.example.book_my_show.Enum.Language;
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
@Builder
@AllArgsConstructor
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String movieName;
    private double rating;
    private int duration;
    @Enumerated(value = EnumType.STRING)
    private Language language;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //movie is parent wrt to show
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList=new ArrayList<>();

}
