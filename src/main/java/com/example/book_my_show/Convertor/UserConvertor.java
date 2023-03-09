package com.example.book_my_show.Convertor;

import com.example.book_my_show.Dtos.UserEntryDto;
import com.example.book_my_show.Entity.User;
import lombok.Data;

public class UserConvertor {
    public static User convertUserEntryDtoToUser(UserEntryDto userEntryDto){
        User user=User.builder().name(userEntryDto.getName()).age(userEntryDto.getAge())
                .email(userEntryDto.getEmail()).mobNo(userEntryDto.getMobNo())
                .address(userEntryDto.getAddress()).build();
        return user;
    }
}
