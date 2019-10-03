package com.mavha.mavhachallengetodobespring.service;

import java.util.List;

import com.mavha.mavhachallengetodobespring.domain.Todo;

public interface TodoService {

	/**
	 * Returns all todo
	 * 
	 * @return {@link List} {@link Todo}
	 */
	List<Todo> getAll();
}
