package com.mavha.mavhachallengetodobespring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}

}
