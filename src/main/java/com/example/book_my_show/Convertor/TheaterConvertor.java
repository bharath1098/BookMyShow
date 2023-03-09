package com.example.book_my_show.Convertor;

import com.example.book_my_show.Dtos.TheaterEntryDto;
import com.example.book_my_show.Entity.Theater;

public class TheaterConvertor {

    public static Theater theaterDtotoEntity(TheaterEntryDto theaterEntryDto){
        Theater theater=Theater.builder().theaterName(theaterEntryDto.getTheaterName())
                .location(theaterEntryDto.getLocation()).build();
        return  theater;
    }
}
