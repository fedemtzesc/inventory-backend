package com.fdxsoft.inventory.response;

/**
 * 03. 	Esta clase sirve en este caso de este primer ejemplo para
 * 		contener los registros obtenidos de la BD, y pueden ser 0, 1 o 
 * 		la cantidad que sea necesaria segun el tipo de consulta
 */

import java.util.List;

import com.fdxsoft.inventory.models.CategoryModel;

import lombok.Data;

@Data
public class CategoryResponse {
	private List<CategoryModel> category;
}
