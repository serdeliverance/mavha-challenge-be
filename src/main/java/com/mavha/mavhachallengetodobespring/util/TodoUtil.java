package com.mavha.mavhachallengetodobespring.util;

import com.mavha.mavhachallengetodobespring.domain.Todo;
import com.mavha.mavhachallengetodobespring.dto.TodoDto;

public class TodoUtil {
	
	public static Todo matchFields(TodoDto tDto, Todo todoDomain) {
		todoDomain.setStatus(tDto.getStatus());
		return todoDomain;
	}
}
