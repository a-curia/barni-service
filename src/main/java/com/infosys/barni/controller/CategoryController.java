package com.infosys.barni.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.barni.entity.Response;
import com.infosys.barni.entity.Category;
import com.infosys.barni.exception.CategoryException;
import com.infosys.barni.service.CategoryService;
import com.infosys.barni.util.PayloadValidatorCategory;


@RestController
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategory(){
    	logger.info("Returning all the Category´s");
		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) throws CategoryException{
    	logger.info("Category id to return " + id);
    	Category category = categoryService.getCategoryById(id);
    	if (category == null || category.getCategoryId() <= 0){
            throw new CategoryException("Category doesn´t exist");
    	}
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeCategoryById(@PathVariable("id") long id) throws CategoryException{
    	logger.info("Category id to remove " + id);
    	Category category = categoryService.getCategoryById(id);
    	if (category == null || category.getCategoryId() <= 0){
            throw new CategoryException("Category to delete doesn´t exist");
    	}
		categoryService.removeCategory(category);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Category has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/category", method = RequestMethod.POST)
   	public ResponseEntity<Category> saveCategory(@RequestBody Category payload) throws CategoryException{
    	logger.info("Payload to save " + payload);
    	if (!PayloadValidatorCategory.validateCreatePayload(payload)){
            throw new CategoryException("Payload malformed, id must not be defined");
    	}
		return new ResponseEntity<Category>(categoryService.saveCategory(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/category", method = RequestMethod.PATCH)
   	public ResponseEntity<Category>  updateCategory(@RequestBody Category payload) throws CategoryException{
    	logger.info("Payload to update " + payload);
    	Category category = categoryService.getCategoryById(payload.getCategoryId());
    	if (category == null || category.getCategoryId() <= 0){
            throw new CategoryException("Category to update doesn´t exist");
    	}
		return new ResponseEntity<Category>(categoryService.saveCategory(payload), HttpStatus.OK);
   	}
	
}