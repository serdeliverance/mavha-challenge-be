package com.mavha.mavhachallengetodobespring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavha.mavhachallengetodobespring.domain.StatusEnum;
import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.repository.TodoDAO;
import com.mavha.mavhachallengetodobespring.repository.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoDAO todoDao;
	
	public List<Todo> getAll() {
		log.info("Getting all todo tasks");
		return todoRepository.findAll();
	}

	public List<Todo> search(Optional<Integer> optId, Optional<String> optDesc, Optional<StatusEnum> optStatus) {
		return todoDao.findTodoByIdDescAndState(optId, optDesc, optStatus);
	}
	
	public Optional<Todo> getById(Long id) {
		return todoRepository.findById(id);
	}

	public Optional<Todo> saveOrUpdate(Todo todo) {
		return Optional.of(todoRepository.save(todo));
	}

	
}
