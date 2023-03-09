package com.example.book_my_show.Entity;

import com.example.book_my_show.Enum.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="shows")
public class Show{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime showTime;
    private LocalDate showDate;
    @Enumerated(value = EnumType.STRING)
    private ShowType showType;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    //show is parent wrt ticket
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> listofBookedTickets=new ArrayList<>();

    //show is child wrt movie
    @ManyToOne
    @JoinColumn
    private Movie movie;

    //show is child wrt theater
    @ManyToOne
    @JoinColumn
    private Theater theater;

    //show is parent wrt to showSeats
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<ShowSeats> listofShowSeats=new ArrayList<>();


}
