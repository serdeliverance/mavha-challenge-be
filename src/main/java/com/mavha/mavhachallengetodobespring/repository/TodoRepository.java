package com.mavha.mavhachallengetodobespring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mavha.mavhachallengetodobespring.domain.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

	List<Todo> findAll();
}
