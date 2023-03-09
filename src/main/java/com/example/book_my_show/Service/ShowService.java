package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.ShowConvertor;
import com.example.book_my_show.Dtos.ShowEntryDto;
import com.example.book_my_show.Entity.*;
import com.example.book_my_show.Enum.SeatType;
import com.example.book_my_show.Repository.MovieRepository;
import com.example.book_my_show.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
  @Autowired
    MovieRepository movieRepository;
  @Autowired
    TheaterRepository theaterRepository;
    public String addShow(ShowEntryDto showEntryDto){
        Show show= ShowConvertor.convertDtoToEntity(showEntryDto);
        int movieId=showEntryDto.getMovieId();
        int theaterId=showEntryDto.getTheaterId();

        Movie movie=movieRepository.findById(movieId).get();
        Theater theater=theaterRepository.findById(theaterId).get();

        List<ShowSeats> showSeatsList=createShowSeatsList(showEntryDto,show);

        show.setListofShowSeats(showSeatsList);

        movie.getShowList().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "show has been added Successfully";


    }

    public List<ShowSeats> createShowSeatsList(ShowEntryDto showEntryDto,Show show){
        List<ShowSeats> showSeatsList=new ArrayList<>();
        int classicSeatPrice=showEntryDto.getClassicSeatPrice();
        int premiumSeatPrice=showEntryDto.getPremiumSeatPrice();
        List<TheaterSeats> theaterSeatsList=show.getTheater().getTheaterSeatsList();
        for(TheaterSeats theaterSeats:theaterSeatsList){
            ShowSeats showSeats=new ShowSeats();

            showSeats.setSeatNo(theaterSeats.getSeatNo());
            showSeats.setSeatType(theaterSeats.getSeatType());

            if(theaterSeats.getSeatType().equals(SeatType.CLASSIC)){
                showSeats.setPrice(classicSeatPrice);
            }
            else{
                showSeats.setPrice(premiumSeatPrice);
            }

            showSeats.setShow(show);
            showSeats.setBooked(false);
            showSeatsList.add(showSeats);
        }
        return showSeatsList;

    }
}
