package com.fdxsoft.inventory.services;

/**
 * 05.	Esta interface sirve para definir todos los metodos que coontendra
 * 		el servicio correspondiente a la entidad Categorias.
 * 
 * 		Se usa asi para satisfacer el principio de la Inyeccion de Dependencias
 */

import org.springframework.http.ResponseEntity;

import com.fdxsoft.inventory.models.CategoryModel;
import com.fdxsoft.inventory.response.CategoryResponseRest;

public interface ICategoryService {
	public ResponseEntity<CategoryResponseRest> search();
	
	public ResponseEntity<CategoryResponseRest> searchById(Long id);
	
	public ResponseEntity<CategoryResponseRest> save(CategoryModel category);
	
	public ResponseEntity<CategoryResponseRest> update(CategoryModel category, Long id);
}
