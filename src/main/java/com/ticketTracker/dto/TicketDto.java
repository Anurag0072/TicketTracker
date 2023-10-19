package com.ticketTracker.dto;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TicketDto { // act as a model in spring mvc application

	private Long id;
	@NotEmpty
	private String title;
	private String url;
	@NotEmpty
	private String content;
	@NotEmpty
	private String shortDescription;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private Set<CommentDto> comments;
}
