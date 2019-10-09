package com.mavha.mavhachallengetodobespring.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mavha.mavhachallengetodobespring.converter.TodoConverter;
import com.mavha.mavhachallengetodobespring.domain.StatusEnum;
import com.mavha.mavhachallengetodobespring.dto.TodoDto;
import com.mavha.mavhachallengetodobespring.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoDto> getTodos() {
		return todoService.getAll().stream() //
				.map(TodoConverter::convertFromTodoToTodoDto) //
				.collect(toList());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "search")
	public List<TodoDto> search(@RequestParam(name = "id", required = false) Optional<Integer> optId,
			@RequestParam(name = "desc", required = false) Optional<String> optDesc,
			@RequestParam(name = "status", required = false) Optional<String> optStatus) {
		
		return todoService.search(optId, optDesc, optStatus.map(s -> StatusEnum.valueOf(s))) //
				.stream() //
				.map(TodoConverter::convertFromTodoToTodoDto) //
				.collect(toList());
	}
}
