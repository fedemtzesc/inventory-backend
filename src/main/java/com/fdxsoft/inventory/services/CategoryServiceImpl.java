package com.fdxsoft.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdxsoft.inventory.dao.ICategoryDao;
import com.fdxsoft.inventory.models.CategoryModel;
import com.fdxsoft.inventory.response.CategoryResponseRest;

@Service	
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryDao categoryDao;
	

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> search() {
		CategoryResponseRest response = new CategoryResponseRest();
		try {
			List<CategoryModel> category = (List<CategoryModel>) categoryDao.findAll();
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("Respuesta ok", "00", "Respuesta Exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Respuesta fail", "-1", "Error al consultar: " + e.getMessage().toUpperCase());
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

}
