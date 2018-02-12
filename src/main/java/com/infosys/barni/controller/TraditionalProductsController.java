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
import com.infosys.barni.entity.TraditionalProduct;
import com.infosys.barni.exception.TraditionalProductException;
import com.infosys.barni.service.TraditionalProductService;
import com.infosys.barni.util.PayloadValidator;


@RestController
public class TraditionalProductsController {
	
	private static final Logger logger = LoggerFactory.getLogger(TraditionalProductsController.class);

	@Autowired
	private TraditionalProductService traditionalProductService;
	
	@RequestMapping(value="/traditional", method=RequestMethod.GET)
	public ResponseEntity<List<TraditionalProduct>> getAllTraditionalProduct(){
    	logger.info("Returning all the TraditionalProduct´s");
		return new ResponseEntity<List<TraditionalProduct>>(traditionalProductService.getAllTraditionalProduct(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/traditional/{id}", method = RequestMethod.GET)
	public ResponseEntity<TraditionalProduct> getTraditionalProductById(@PathVariable("id") long id) throws TraditionalProductException{
    	logger.info("TraditionalProduct id to return " + id);
    	TraditionalProduct traditionalProduct = traditionalProductService.getTraditionalProductById(id);
    	if (traditionalProduct == null || traditionalProduct.getProductId() <= 0){
            throw new TraditionalProductException("TraditionalProduct doesn´t exist");
    	}
		return new ResponseEntity<TraditionalProduct>(traditionalProductService.getTraditionalProductById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/traditional/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeTraditionalProductById(@PathVariable("id") long id) throws TraditionalProductException{
    	logger.info("TraditionalProduct id to remove " + id);
    	TraditionalProduct traditionalProduct = traditionalProductService.getTraditionalProductById(id);
    	if (traditionalProduct == null || traditionalProduct.getProductId() <= 0){
            throw new TraditionalProductException("TraditionalProduct to delete doesn´t exist");
    	}
		traditionalProductService.removeTraditionalProduct(traditionalProduct);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "TraditionalProduct has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/traditional", method = RequestMethod.POST)
   	public ResponseEntity<TraditionalProduct> saveTraditionalProduct(@RequestBody TraditionalProduct payload) throws TraditionalProductException{
    	logger.info("Payload to save " + payload);
    	if (!PayloadValidator.validateCreatePayload(payload)){
            throw new TraditionalProductException("Payload malformed, id must not be defined");
    	}
		return new ResponseEntity<TraditionalProduct>(traditionalProductService.saveTraditionalProduct(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/traditional", method = RequestMethod.PATCH)
   	public ResponseEntity<TraditionalProduct>  updateTraditionalProduct(@RequestBody TraditionalProduct payload) throws TraditionalProductException{
    	logger.info("Payload to update " + payload);
    	TraditionalProduct traditionalProduct = traditionalProductService.getTraditionalProductById(payload.getProductId());
    	if (traditionalProduct == null || traditionalProduct.getProductId() <= 0){
            throw new TraditionalProductException("TraditionalProduct to update doesn´t exist");
    	}
		return new ResponseEntity<TraditionalProduct>(traditionalProductService.saveTraditionalProduct(payload), HttpStatus.OK);
   	}
	
}