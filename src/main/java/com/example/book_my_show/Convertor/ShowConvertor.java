package com.example.book_my_show.Convertor;

import com.example.book_my_show.Dtos.ShowEntryDto;
import com.example.book_my_show.Entity.Show;

public class ShowConvertor {
    public static Show convertDtoToEntity(ShowEntryDto showEntryDto){
        Show show=Show.builder().showDate(showEntryDto.getLocalDate()).showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType()).build();
        return show;
    }
}
