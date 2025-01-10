package com.fdxsoft.inventory.controllers;

/**
 * 08.	Finalmente implemento el servicio dentro de un objeto controlador para 
 * 		poder proveer la consulta de las categorias hacia el mundo externo.
 * 
 * 		Esto se hace 
 * 		1. Creando un mapeo para definir cual sera el end-point dela consulta
 * 		2. El mapeo proincpial se establece en la clase principal
 * 		3. Posteriormente se crea el mapeo puntual por cada uno de los metodos de consulta
 * 		4. Finalmente cada uno de los metodos llamara al servicio correspondiente para 
 * 		   efectuar la consulta o procesamiento necesario para generar la respuesta esperada
 * 		   por el cliente que hace dicha consulta.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdxsoft.inventory.models.CategoryModel;
import com.fdxsoft.inventory.response.CategoryResponseRest;
import com.fdxsoft.inventory.services.ICategoryService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	@Autowired
	private ICategoryService categoryService;
	
	/***
	 * Get All Categories
	 * @return
	 */
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategories(){
		ResponseEntity<CategoryResponseRest> response = categoryService.search();
		return response;
	}
	
	/***
	 * Get a category by its id
	 * @param id
	 * @return an object of type CategoryModel if it is found in the bd
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> searchCategoryById(@PathVariable Long id) {
		ResponseEntity<CategoryResponseRest> response = categoryService.searchById(id);
		return response;
	}
	
	/**
	 * Save a new Category
	 * @param categoryModel
	 * @return
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoryResponseRest> saveCategory(@RequestBody CategoryModel categoryModel) {
		ResponseEntity<CategoryResponseRest> response = categoryService.save(categoryModel);
		return response;
	}
	
	/**
	 * Update a Category
	 * @param id
	 * @param categoryModel
	 * @return
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> updateCategory(@RequestBody CategoryModel categoryModel, @PathVariable Long id) {
		ResponseEntity<CategoryResponseRest> response = categoryService.update(categoryModel, id);
		return response;
	}
	
	/**
	 * Delte a category
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> deleteCategory(@PathVariable Long id) {
		ResponseEntity<CategoryResponseRest> response = categoryService.deleteById(id);
		return response;
	}
	
}
