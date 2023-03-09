package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.UserConvertor;
import com.example.book_my_show.Dtos.UserEntryDto;
import com.example.book_my_show.Entity.User;
import com.example.book_my_show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{
            User user= UserConvertor.convertUserEntryDtoToUser(userEntryDto);
            userRepository.save(user);
            return "user created successfully";
    }
}
