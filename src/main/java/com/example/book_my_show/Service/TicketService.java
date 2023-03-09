package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.TicketConverter;
import com.example.book_my_show.Dtos.TicketEntryDto;
import com.example.book_my_show.Entity.Show;
import com.example.book_my_show.Entity.ShowSeats;
import com.example.book_my_show.Entity.Ticket;
import com.example.book_my_show.Entity.User;
import com.example.book_my_show.Enum.SeatType;
import com.example.book_my_show.Repository.ShowRepository;
import com.example.book_my_show.Repository.TicketRepository;
import com.example.book_my_show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;
    public String bookTicked(TicketEntryDto ticketEntryDto) throws Exception{
        Ticket ticket= TicketConverter.convertEntryDtoToEntity(ticketEntryDto);

        Show show=showRepository.findById(ticketEntryDto.getShowId()).get();
        User user=userRepository.findById(ticketEntryDto.getUserId()).get();

       // check if requested seat are  available or not
        boolean isvalidrequest=cheakIfSeatsOrAvailable(ticketEntryDto,show);
        int totalAmount=0;
        if(isvalidrequest==false){
            throw new Exception("Requested seats are not available");
        }
        else{
            List<ShowSeats> showSeatsList=show.getListofShowSeats();
            List<String> requestedSeatsList=ticketEntryDto.getRequestedSeat();

            for(ShowSeats showSeats:showSeatsList){
                if(requestedSeatsList.contains(showSeats.getSeatNo())){
                    showSeats.setBooked(true);
                    totalAmount+=showSeats.getPrice();
                    showSeats.setBookedAt(new Date());
                }
            }
            ticket.setTotalAmount(totalAmount);
            ticket.setMovieName(show.getMovie().getMovieName());
            ticket.setShowDate(show.getShowDate());
            ticket.setShowTime(show.getShowTime());
            ticket.setTheaterName(show.getTheater().getTheaterName());

            //we need to set that string that talked about Requested seats
            String bookedTicket=allocatedSeatFromShowSeat(requestedSeatsList);
            ticket.setBookedSeat(bookedTicket);

            //foreign key attributes
            ticket.setShow(show);
            ticket.setUser(user);

            //save the parents
            show.getListofBookedTickets().add(ticket);
            showRepository.save(show);

            user.getBookedTicket().add(ticket);
            userRepository.save(user);
            return "Ticket booked succesfully";
        }

    }
    public boolean cheakIfSeatsOrAvailable(TicketEntryDto ticketEntryDto,Show show){
        List<String> requestedSeatList=ticketEntryDto.getRequestedSeat();
        List<ShowSeats> showSeatsList=show.getListofShowSeats();

        for(ShowSeats showSeats:showSeatsList){
            if(requestedSeatList.contains(showSeats.getSeatNo())){
                if(showSeats.isBooked()==true){
                    return false;
                }
            }
        }
        return true;
    }
    public String allocatedSeatFromShowSeat(List<String> requestedSeatsList){
        String bookedTicket="";

        for(String seat:requestedSeatsList){
            bookedTicket+=seat+" ";
        }
        return bookedTicket;
    }
}
