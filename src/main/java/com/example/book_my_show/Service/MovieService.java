package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.MovieConvertor;
import com.example.book_my_show.Dtos.MovieEntryDto;
import com.example.book_my_show.Entity.Movie;
import com.example.book_my_show.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
   public String addMovie( MovieEntryDto movieEntryDto){

       Movie movie= MovieConvertor.convertMovieDtoToMovie(movieEntryDto);
       movieRepository.save(movie);

       return "Movie added successfully";
   }
}
