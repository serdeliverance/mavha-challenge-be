package com.mavha.mavhachallengetodobespring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavha.mavhachallengetodobespring.domain.StatusEnum;
import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.repository.TodoDAO;
import com.mavha.mavhachallengetodobespring.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoDAO todoDao;
	
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}

	public List<Todo> search(Optional<Integer> optId, Optional<String> optDesc, Optional<StatusEnum> optStatus) {
		return todoDao.findTodoByIdDescAndState(optId, optDesc, optStatus);
	}
}
