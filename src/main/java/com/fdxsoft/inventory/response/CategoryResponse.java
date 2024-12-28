package com.fdxsoft.inventory.response;

import java.util.List;

import com.fdxsoft.inventory.models.CategoryModel;

import lombok.Data;

@Data
public class CategoryResponse {
	private List<CategoryModel> category;
}
