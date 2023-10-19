package com.ticketTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketTracker.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Optional<Ticket> findByUrl(String url);//create query using method name, spring jpa will pass internally and use hibernate
	
	//JPQL for search operation: use JPA enntity and its field names
	@Query("SELECT p from Ticket p WHERE " +
	         "p.title LIKE CONCAT('%', :query, '%') OR " +
			 "p.shortDescription LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);
}
