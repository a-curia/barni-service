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
import com.infosys.barni.entity.Product;
import com.infosys.barni.exception.ProductException;
import com.infosys.barni.service.ProductService;
import com.infosys.barni.util.PayloadValidatorProduct;


@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProduct(){
    	logger.info("Returning all the Product´s");
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductException{
    	logger.info("Product id to return " + id);
    	Product product = productService.getProductById(id);
    	if (product == null || product.getProductId() <= 0){
            throw new ProductException("Product doesn´t exist");
    	}
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeProductById(@PathVariable("id") long id) throws ProductException{
    	logger.info("Product id to remove " + id);
    	Product product = productService.getProductById(id);
    	if (product == null || product.getProductId() <= 0){
            throw new ProductException("Product to delete doesn´t exist");
    	}
		productService.removeProduct(product);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Product has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
   	public ResponseEntity<Product> saveProduct(@RequestBody Product payload) throws ProductException{
    	logger.info("Payload to save " + payload);
    	if (!PayloadValidatorProduct.validateCreatePayload(payload)){
            throw new ProductException("Payload malformed, id must not be defined");
    	}
		return new ResponseEntity<Product>(productService.saveProduct(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/product", method = RequestMethod.PATCH)
   	public ResponseEntity<Product>  updateProduct(@RequestBody Product payload) throws ProductException{
    	logger.info("Payload to update " + payload);
    	Product product = productService.getProductById(payload.getProductId());
    	if (product == null || product.getProductId() <= 0){
            throw new ProductException("Product to update doesn´t exist");
    	}
		return new ResponseEntity<Product>(productService.saveProduct(payload), HttpStatus.OK);
   	}
	
}