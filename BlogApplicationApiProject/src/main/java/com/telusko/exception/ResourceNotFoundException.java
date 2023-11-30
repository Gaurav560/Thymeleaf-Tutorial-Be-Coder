package com.telusko.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private Integer fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Integer userId) {
		super(String.format("%s not found with %s:%l", resourceName, fieldName, userId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = userId;
	}

}
