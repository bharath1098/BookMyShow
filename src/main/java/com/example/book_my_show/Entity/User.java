package com.example.book_my_show.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String mobNo;

    private String address;

    //user is parent wrt ticket
    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    private List<Ticket> bookedTicket=new ArrayList<>();
}
