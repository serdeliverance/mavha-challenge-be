package com.mavha.mavhachallengetodobespring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mavha.mavhachallengetodobespring.validator.StatusValid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TodoDto {

	private Long id;
	private String name;
	private String description;
	@StatusValid
	private String status;
	private String imagePath;
}
