package com.mavha.mavhachallengetodobespring.dto;

import com.mavha.mavhachallengetodobespring.domain.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoDto {

	private Integer id;
	private String description;
	private StatusEnum status;
	private String imagePath;
}
