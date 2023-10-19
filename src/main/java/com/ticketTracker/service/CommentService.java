package com.ticketTracker.service;

import java.util.List;

import com.ticketTracker.dto.CommentDto;

public interface CommentService {

	void createComment(String ticketUrl, CommentDto commentDto);
	
	List<CommentDto> findAllComments();
	
	void deleteComment(Long CommentId);
}
