package com.example.book_my_show.Controller;

import com.example.book_my_show.Dtos.UserEntryDto;
import com.example.book_my_show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){
        try{
            String result=userService.addUser(userEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);

        }catch (Exception e){
            String response="User not added";
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

    }
}
