package com.mavha.mavhachallengetodobespring.converter;

import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.dto.TodoDto;

public class TodoConverter {

	public static TodoDto convertFromTodoToTodoDto(Todo source) {
		TodoDto result = new TodoDto();
		
		result.setId(source.getId());
		result.setName(source.getName());
		result.setDescription(source.getDescription());
		result.setStatus(source.getStatus());
		result.setImagePath(source.getImagePath());
		
		return result;
	}
}
