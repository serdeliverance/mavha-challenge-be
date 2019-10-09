package com.mavha.mavhachallengetodobespring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "image_path")
	private String imagePath;
	
	public static TodoBuilder builder() {
		return new TodoBuilder();
	}
	
	public static class TodoBuilder {
		
		private Todo todo;
		
		public TodoBuilder() {
			todo = new Todo();
		}
		
		public TodoBuilder withName(String name) {
			todo.setName(name);
			return this;
		}
		
		public TodoBuilder withDescription(String description) {
			todo.setDescription(description);
			return this;
		}
		
		public TodoBuilder withStatus(String status) {
			todo.setStatus(status);
			return this;
		}
		
		public TodoBuilder withImagePath(String imagePath) {
			todo.setImagePath(imagePath);
			return this;
		}
		
		public Todo build() {
			return todo;
		}
	}
}
