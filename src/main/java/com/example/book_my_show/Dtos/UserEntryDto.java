package com.example.book_my_show.Dtos;

import lombok.Data;

@Data
public class UserEntryDto {
    private String name;
    private int age;
    private String email;
    private String mobNo;

    private String address;
}
