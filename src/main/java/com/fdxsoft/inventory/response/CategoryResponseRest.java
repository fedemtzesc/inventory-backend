package com.fdxsoft.inventory.response;

/**
 * 04.	Esta clase conteendra la respuesta con los metadatos derivados del
 * 		resultado de la consulta, y con los datos o registros obtenidos de la 
 * 		Base de Datos. Y al heredarla de ResponseRest, tendremos siempre una 
 * 		respuesta uniforme a la hora de responder los requests de las API
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseRest extends ResponseRest {
	private CategoryResponse categoryResponse = new CategoryResponse();
}
