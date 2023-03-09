package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.TheaterConvertor;
import com.example.book_my_show.Dtos.TheaterEntryDto;
import com.example.book_my_show.Entity.Theater;
import com.example.book_my_show.Entity.TheaterSeats;
import com.example.book_my_show.Enum.SeatType;
import com.example.book_my_show.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
     TheaterRepository theaterRepository;
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        Theater theater = TheaterConvertor.theaterDtotoEntity(theaterEntryDto);

        List<TheaterSeats> theaterSeatsList=createTheaterSeats(theaterEntryDto,theater);

        theaterRepository.save(theater);
        return "theater added Succesfully";

    }
    public List<TheaterSeats> createTheaterSeats(TheaterEntryDto theaterEntryDto,Theater theater){
        List<TheaterSeats> theaterSeatsList=new ArrayList<>();
        int classicSeatCount=theaterEntryDto.getClassicSeatCount();
        int premiumSeatCount=theaterEntryDto.getPremiumSeatCount();
        for(int i=1;i<=classicSeatCount;i++){
            TheaterSeats theaterSeats=TheaterSeats.builder().seatType(SeatType.CLASSIC).seatNo(i+"C").theater(theater).build();
            theaterSeatsList.add(theaterSeats);

        }
        for(int i=1;i<=premiumSeatCount;i++){
            TheaterSeats theaterSeats=TheaterSeats.builder().seatType(SeatType.PREMIUM).seatNo(i+"P").theater(theater).build();
            theaterSeatsList.add(theaterSeats);
        }
        return  theaterSeatsList;
    }
}
