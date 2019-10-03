package com.mavha.mavhachallengetodobespring.controller;

import java.util.List;
import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavha.mavhachallengetodobespring.converter.TodoConverter;
import com.mavha.mavhachallengetodobespring.dto.TodoDto;
import com.mavha.mavhachallengetodobespring.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoDto> getTodos() {
		return todoService.getAll()
				.stream() //
				.map(TodoConverter::convertFromTodoToTodoDto) //
				.collect(toList());
	}
}
