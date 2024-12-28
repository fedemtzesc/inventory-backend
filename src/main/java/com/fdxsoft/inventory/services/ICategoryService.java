package com.fdxsoft.inventory.services;

import org.springframework.http.ResponseEntity;

import com.fdxsoft.inventory.response.CategoryResponseRest;

public interface ICategoryService {
	public ResponseEntity<CategoryResponseRest> search();
}
