package com.fdxsoft.inventory.dao;

/**
 * 06.	Esta insteface se utiliza para crear un enlace entre la clase del
 * 		tipo Servicio y la Base de Datos para poder aplicarle consultas de
 * 		todo tipo y asi poderle proporcionar los datos que necesita la clase
 * 		del tipo Servicio.
 */

import org.springframework.data.repository.CrudRepository;

import com.fdxsoft.inventory.models.CategoryModel;

public interface ICategoryDao extends CrudRepository<CategoryModel, Long>{
	
}
