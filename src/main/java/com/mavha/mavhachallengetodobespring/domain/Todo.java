package com.mavha.mavhachallengetodobespring.domain;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a todo domain object
 * 
 * @author SergioCano
 *
 */
@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
public class Todo {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private StatusEnum status;
	
	@Column(name = "imagePath")
	private String imagePath;
}
