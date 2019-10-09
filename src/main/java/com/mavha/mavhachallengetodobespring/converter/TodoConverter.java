package com.mavha.mavhachallengetodobespring.converter;

import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.dto.TodoDto;
import com.mavha.mavhachallengetodobespring.dto.TodoUpdateStateDto;

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

	public static Todo convertFromTodoUpdateStateDtoToTodo(TodoUpdateStateDto todoUpdateStateDto, Todo todoDomain) {
		Todo todo = new Todo();
		
		todo.setId(todoDomain.getId());
		todo.setName(todoDomain.getName());
		todo.setDescription(todoDomain.getDescription());
		todo.setImagePath(todoDomain.getImagePath());
		todo.setStatus(todoUpdateStateDto.getStatus());
		
		return todo;
	}
}
