package com.mavha.mavhachallengetodobespring.controller;

import static com.mavha.mavhachallengetodobespring.dto.TodoDto.EMPTY_TODO_DTO;
import static com.mavha.mavhachallengetodobespring.util.TodoUtil.matchFields;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mavha.mavhachallengetodobespring.converter.TodoConverter;
import com.mavha.mavhachallengetodobespring.domain.StatusEnum;
import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.dto.TodoDto;
import com.mavha.mavhachallengetodobespring.service.TodoService;
import com.mavha.mavhachallengetodobespring.storage.StorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private StorageService storageService;

	@GetMapping()
	public List<TodoDto> getTodos() {
		log.info("Getting all todo tasks");
		return todoService.getAll().stream() //
				.map(TodoConverter::convertFromTodoToTodoDto) //
				.collect(toList());
	}
	
	@GetMapping("/{id}")
	public TodoDto getById(@PathVariable("id") Long id) {
		log.info("Getting todo by id: {}" , id);
		return todoService.getById(id) //
				.map(TodoConverter::convertFromTodoToTodoDto).orElse(EMPTY_TODO_DTO);
	}

	@GetMapping("search")
	public List<TodoDto> search(@RequestParam(name = "id", required = false) Optional<Integer> optId,
			@RequestParam(name = "desc", required = false) Optional<String> optDesc,
			@RequestParam(name = "status", required = false) Optional<String> optStatus) {
		log.info("Searching todo by criteria");
		return todoService.search(optId, optDesc, optStatus.map(s -> StatusEnum.valueOf(s))) //
				.stream() //
				.map(TodoConverter::convertFromTodoToTodoDto) //
				.collect(toList());
	}

	@PutMapping("{id}")
	public TodoDto update(@Valid @RequestBody TodoDto todoDto, @PathVariable Integer id) {
		log.info("Updating todo id: {}", todoDto.getId());
		return todoService.getById(todoDto.getId()) //
				.flatMap(t -> todoService.saveOrUpdate(matchFields(todoDto, t))) //
				.map(TodoConverter::convertFromTodoToTodoDto).orElse(EMPTY_TODO_DTO); // TODO change this exception
	}

	@PostMapping()
	public TodoDto create(@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("status") String status, @RequestParam(name = "file", required = false) MultipartFile file) {
		log.info("Creating todo task");
		String fileName = storageService.storeFile(file);
		String imagePath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName)
				.toUriString();

		return todoService.saveOrUpdate(Todo.builder() //
				.withName(name).withDescription(description) //
				.withStatus(status).withImagePath(imagePath).build()) //
				.map(TodoConverter::convertFromTodoToTodoDto).orElseThrow(RuntimeException::new); // TODO change this exception
	}
}
