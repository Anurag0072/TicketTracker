package com.ticketTracker.service;

import java.util.List;

import com.ticketTracker.dto.TicketDto;
import com.ticketTracker.entity.Ticket;

public interface TicketService {
	
	List<TicketDto> findAllTickets();
	
	void createTicket(TicketDto ticketDto);
	
	TicketDto findTicketById(Long ticketId);
	
	void updateTicket(TicketDto ticketDto);
	
	void deleteTicket(Long ticketId);
	
	TicketDto findTicketByUrl(String ticketUrl);
	
	List<TicketDto> searchTickets(String query);

}
