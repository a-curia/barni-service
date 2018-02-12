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
import com.infosys.barni.entity.User;
import com.infosys.barni.exception.UserException;
import com.infosys.barni.service.UserService;
import com.infosys.barni.util.PayloadValidatorUser;


@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser(){
    	logger.info("Returning all the User´s");
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) throws UserException{
    	logger.info("User id to return " + id);
    	User user = userService.getUserById(id);
    	if (user == null || user.getId() <= 0){
            throw new UserException("User doesn´t exist");
    	}
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeUserById(@PathVariable("id") long id) throws UserException{
    	logger.info("User id to remove " + id);
    	User user = userService.getUserById(id);
    	if (user == null || user.getId() <= 0){
            throw new UserException("User to delete doesn´t exist");
    	}
		userService.removeUser(user);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "User has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
   	public ResponseEntity<User> saveUser(@RequestBody User payload) throws UserException{
    	logger.info("Payload to save " + payload);
    	if (!PayloadValidatorUser.validateCreatePayload(payload)){
            throw new UserException("Payload malformed, id must not be defined");
    	}
		return new ResponseEntity<User>(userService.saveUser(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
   	public ResponseEntity<User>  updateUser(@RequestBody User payload) throws UserException{
    	logger.info("Payload to update " + payload);
    	User user = userService.getUserById(payload.getId());
    	if (user == null || user.getId() <= 0){
            throw new UserException("User to update doesn´t exist");
    	}
		return new ResponseEntity<User>(userService.saveUser(payload), HttpStatus.OK);
   	}
	
}