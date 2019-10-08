package com.mavha.mavhachallengetodobespring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavha.mavhachallengetodobespring.domain.StatusEnum;
import com.mavha.mavhachallengetodobespring.domain.Todo;

@Repository
public class TodoDAO {

	@Autowired
	private EntityManager em;

	public List<Todo> findTodoByIdDescAndState(Optional<Integer> optId, Optional<String> optDesc,
			Optional<StatusEnum> optStatus) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Todo> criteriaQuery = criteriaBuilder.createQuery(Todo.class);

		Root<Todo> todo = criteriaQuery.from(Todo.class);
		List<Predicate> predicates = new ArrayList<>();

		optId.ifPresent(id -> predicates.add(criteriaBuilder.equal(todo.get("id"), id)));
		optDesc.ifPresent(desc -> predicates.add(criteriaBuilder.like(todo.get("description"), "%" + desc + "%")));
		optStatus.ifPresent(status -> predicates.add(criteriaBuilder.equal(todo.get("status"), status.name())));

		criteriaQuery.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(criteriaQuery).getResultList();
	}
}
