package com.example.book_my_show.Convertor;

import com.example.book_my_show.Dtos.TicketEntryDto;
import com.example.book_my_show.Entity.Ticket;

public class TicketConverter {
    public static Ticket convertEntryDtoToEntity(TicketEntryDto ticketEntryDto){
        Ticket ticket=new Ticket();
        return ticket;
    }
}
