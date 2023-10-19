package com.ticketTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketTracker.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
