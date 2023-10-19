package com.ticketTracker.mapper;

import com.ticketTracker.dto.TicketDto;
import com.ticketTracker.entity.Ticket;

//it will map ticket entity  to ticketDto and vice versa
public class TicketMapper {
	
	//map ticket entity to ticket dto
	
	public static TicketDto mapToTicketDto(Ticket ticket) {
		return TicketDto.builder()
				.id(ticket.getId())
				.title(ticket.getTitle())
				.url(ticket.getUrl())
				.content(ticket.getContent())
				.shortDescription(ticket.getShortDescription())
				.createdOn(ticket.getCreatedOn())
				.updatedOn(ticket.getUpdatedOn())
				.build();
	}
	
	//map ticketDto to ticket entity
	public static Ticket maptoTicket(TicketDto ticketDto) {
		return Ticket.builder()
				.id(ticketDto.getId())
				.title(ticketDto.getTitle())
				.content(ticketDto.getContent())
				.url(ticketDto.getUrl())
				.shortDescription(ticketDto.getShortDescription())
			    .createdOn(ticketDto.getCreatedOn())
			    .updatedOn(ticketDto.getUpdatedOn())
			    .build();
				
	}
	

}
