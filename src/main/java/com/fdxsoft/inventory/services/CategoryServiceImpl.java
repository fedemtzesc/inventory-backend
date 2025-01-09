package com.fdxsoft.inventory.services;

import java.util.ArrayList;

/**
 * 07.	Esta clase implementara cada uno de los metodos definidos dentro
 * 		de su interface correspondiente para poder acceder a los datos y 
 * 		para satisfacer el concepto de Inyeccion de Dependencias.
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdxsoft.inventory.dao.ICategoryDao;
import com.fdxsoft.inventory.models.CategoryModel;
import com.fdxsoft.inventory.response.CategoryResponseRest;

@Service
public class CategoryServiceImpl implements ICategoryService {
	// La variable categoryDao le proporcionara toda la informacion de la BD
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> search() {
		// Defino una instancia de la clase que coontendra los metadatos y los datos de
		// la BD
		CategoryResponseRest response = new CategoryResponseRest();
		try {
			// Creo una Lista para contener todos los registros de la BD por medio de la
			// consulta
			List<CategoryModel> category = (List<CategoryModel>) categoryDao.findAll();
			// Meto la lista resultante en la clase bi-funcional por la parte de los objetos
			// de datos
			response.getCategoryResponse().setCategory(category);
			// En el objeto bi-funcional defino los metadatos de acuerdo al resultado
			// exitoso
			response.setMetadata("Respuesta ok", "00", "Respuesta Exitosa");
		} catch (Exception e) {
			// En el objeto bi-funcional solamente definire los metadatos de acuerdo al
			// resultado NO EXITOSO
			response.setMetadata("Respuesta fail", "-1", "Error al consultar: " + e.getMessage().toUpperCase());
			// Y devuelvo el objeto bi-funcional encapsulado en un objeto ResponseEntity,
			// sin datos, pero con informacion del error que paso
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Si no hubo errores, devolvere el objeto bi-funcional encapsulado en el objeto
		// ResponseEntity
		// como respuesta a la consulta REST
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> searchById(Long id) {
		// Defino una instancia de la clase que coontendra los metadatos y los datos de
		// la BD
		CategoryResponseRest response = new CategoryResponseRest();
		List<CategoryModel> list = new ArrayList<>();

		try {
			Optional<CategoryModel> category = categoryDao.findById(id);
			// Preguntamos si category contiene al menos un objeto
			if (category.isPresent()) {
				list.add(category.get());
				response.getCategoryResponse().setCategory(list);
				response.setMetadata("Respuesta ok", "00", "Categoria encontrada.");
			} else {
				response.setMetadata("Respuesta fail", "-2", "Categoria no encontrada.");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// En el objeto bi-funcional solamente definire los metadatos de acuerdo al
			// resultado NO EXITOSO
			response.setMetadata("Respuesta fail", "-1", "Error al consultar por Id: " + e.getMessage().toUpperCase());
			// Y devuelvo el objeto bi-funcional encapsulado en un objeto ResponseEntity,
			// sin datos, pero con informacion del error que paso
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Si no hubo errores, devolvere el objeto bi-funcional encapsulado en el objeto
		// ResponseEntity
		// como respuesta a la consulta REST
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> save(CategoryModel categoryToSave) {
		// Defino una instancia de la clase que coontendra los metadatos y los datos de
		// la BD
		CategoryResponseRest response = new CategoryResponseRest();
		List<CategoryModel> list = new ArrayList<>();

		try {
			CategoryModel categorySaved = categoryDao.save(categoryToSave);
			if (categorySaved != null) {
				list.add(categorySaved);
				response.getCategoryResponse().setCategory(list);
				response.setMetadata("Respuesta ok", "00", "Categoria guardada con exito.");
			} else {
				response.setMetadata("Respuesta fail", "-2", "No fue posible guardar la categoria.");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// En el objeto bi-funcional solamente definire los metadatos de acuerdo al
			// resultado NO EXITOSO
			response.setMetadata("Respuesta fail", "-1",
					"Error al guardar nueva categoria: " + e.getMessage().toUpperCase());
			// Y devuelvo el objeto bi-funcional encapsulado en un objeto ResponseEntity,
			// sin datos, pero con informacion del error que paso
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Si no hubo errores, devolvere el objeto bi-funcional encapsulado en el objeto
		// ResponseEntity
		// como respuesta a la consulta REST
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> update(CategoryModel category, Long id) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<CategoryModel> list = new ArrayList<>();

		try {
			Optional<CategoryModel> categoryModel = categoryDao.findById(id);

			if (categoryModel.isPresent()) {
				// Se procede a actualizar el registro
				categoryModel.get().setName(category.getName());
				categoryModel.get().setDescription(category.getDescription());

				CategoryModel categoryUpdated = categoryDao.save(categoryModel.get());

				if (categoryUpdated != null) {
					list.add(categoryUpdated);
					response.getCategoryResponse().setCategory(list);
					response.setMetadata("Respuesta ok", "00", "Categoria actualizada");
				} else {
					response.setMetadata("Respuesta fail", "-3", "No fue posible actualizar la categoria.");
					return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			} else {
				// Se procede a avisar al cliente que no se encontro la categoria
				response.setMetadata("Respuesta fail", "-2", "Categoria no encontrada.");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// En el objeto bi-funcional solamente definire los metadatos de acuerdo al
			// resultado NO EXITOSO
			response.setMetadata("Respuesta fail", "-1",
					"Error al actualizar categoria: " + e.getMessage().toUpperCase());
			// Y devuelvo el objeto bi-funcional encapsulado en un objeto ResponseEntity,
			// sin datos, pero con informacion del error que paso
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Si no hubo errores, devolvere el objeto bi-funcional encapsulado en el objeto
		// ResponseEntity
		// como respuesta a la consulta REST
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

}
