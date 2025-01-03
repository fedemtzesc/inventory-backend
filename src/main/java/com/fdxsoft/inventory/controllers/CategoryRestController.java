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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdxsoft.inventory.response.CategoryResponseRest;
import com.fdxsoft.inventory.services.ICategoryService;

import jakarta.websocket.server.PathParam;

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
	
}
