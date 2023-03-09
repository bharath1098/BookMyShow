package com.example.book_my_show.Convertor;

import com.example.book_my_show.Dtos.MovieEntryDto;
import com.example.book_my_show.Entity.Movie;

public class MovieConvertor {
    public static Movie convertMovieDtoToMovie(MovieEntryDto movieEntryDto){
        Movie movie=Movie.builder().movieName(movieEntryDto.getMovieName()).genre(movieEntryDto.getGenre())
                .duration(movieEntryDto.getDuration()).rating(movieEntryDto.getRating())
                .language(movieEntryDto.getLanguage()).build();
        return movie;
    }
}
