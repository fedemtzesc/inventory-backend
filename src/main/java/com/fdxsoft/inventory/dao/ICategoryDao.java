package com.fdxsoft.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdxsoft.inventory.models.CategoryModel;

public interface ICategoryDao extends CrudRepository<CategoryModel, Long>{
	
}
