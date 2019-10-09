package com.mavha.mavhachallengetodobespring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoUpdateStateDto {

	private Long id;
	private String status;
}
