package com.ticketTracker.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ticketTracker.dto.CommentDto;
import com.ticketTracker.entity.Comment;
import com.ticketTracker.entity.Ticket;
import com.ticketTracker.mapper.CommentMapper;
import com.ticketTracker.repository.CommentRepository;
import com.ticketTracker.repository.TicketRepository;

import com.ticketTracker.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;
	private TicketRepository ticketRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository, TicketRepository ticketRepository) {
		this.commentRepository =commentRepository;
		this.ticketRepository = ticketRepository;
	}
	
	
	@Override
	public void createComment(String ticketUrl, CommentDto commentDto) {
		Ticket ticket = ticketRepository.findByUrl(ticketUrl).get();
		Comment comment = CommentMapper.mapToComment(commentDto);
		comment.setTicket(ticket);
		commentRepository.save(comment);
	}

	@Override
	public List<CommentDto> findAllComments() {
	    List<Comment> comments = commentRepository.findAll();
	    return comments.stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
	}
	
	@Override
	public void deleteComment(Long CommentId) {
		commentRepository.deleteById(CommentId);
	}
	
	
}
