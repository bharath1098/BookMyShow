package com.example.book_my_show.Dtos;

import com.example.book_my_show.Enum.Genre;
import com.example.book_my_show.Enum.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;
    private double rating;
    private int duration;
    private Language language;
    private Genre genre;
}
