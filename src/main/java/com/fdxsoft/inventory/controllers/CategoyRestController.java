package com.fdxsoft.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdxsoft.inventory.response.CategoryResponseRest;
import com.fdxsoft.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoyRestController {
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategories(){
		ResponseEntity<CategoryResponseRest> response = categoryService.search();
		return response;
	}
}
