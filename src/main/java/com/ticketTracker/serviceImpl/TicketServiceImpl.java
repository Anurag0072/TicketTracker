package com.ticketTracker.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ticketTracker.dto.TicketDto;
import com.ticketTracker.entity.Ticket;
import com.ticketTracker.mapper.TicketMapper;
import com.ticketTracker.repository.TicketRepository;
import com.ticketTracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Override
	public List<TicketDto> findAllTickets() {
		List<Ticket> tickets = ticketRepository.findAll();
		return tickets.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());
	}

	@Override
	public void createTicket(TicketDto ticketDto) {
		Ticket ticket = TicketMapper.maptoTicket(ticketDto);
		ticketRepository.save(ticket);
		
	}

	@Override
	public TicketDto findTicketById(Long ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		return TicketMapper.mapToTicketDto(ticket);
	}

	@Override
	public void updateTicket(TicketDto ticketDto) {
		Ticket ticket = TicketMapper.maptoTicket(ticketDto);
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Long ticketId) {
		ticketRepository.deleteById(ticketId);
		
	}

	@Override
	public TicketDto findTicketByUrl(String ticketUrl) {
		Ticket ticket = ticketRepository.findByUrl(ticketUrl).get();
		return TicketMapper.mapToTicketDto(ticket);
	}

	@Override
	public List<TicketDto> searchTickets(String query) {
		List<Ticket> tickets = ticketRepository.searchTickets(query);
		return tickets.stream().map(TicketMapper :: mapToTicketDto)
				.collect(Collectors.toList());
	}

}
