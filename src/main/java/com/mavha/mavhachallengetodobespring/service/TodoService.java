package com.mavha.mavhachallengetodobespring.service;

import java.util.List;
import java.util.Optional;

import com.mavha.mavhachallengetodobespring.domain.StatusEnum;
import com.mavha.mavhachallengetodobespring.domain.Todo;

public interface TodoService {

	List<Todo> getAll();

	List<Todo> search(Optional<Integer> optId, Optional<String> optDesc, Optional<StatusEnum> map);
}
