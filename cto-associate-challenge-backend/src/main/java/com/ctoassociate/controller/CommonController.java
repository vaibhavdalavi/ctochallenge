package com.ctoassociate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctoassociate.models.ServiceResponse;
import com.ctoassociate.models.User;
import com.ctoassociate.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ctoassociate")
@CrossOrigin
@RestController
@RequestMapping("/ctoassociate")
public class CommonController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CommonController.class);
	
	@Autowired
	UserRepository userRepository;
	
	@ApiOperation(nickname = "createUser", value = "To create a new user.")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = "application/json",  produces = "application/json")
	public ResponseEntity<ServiceResponse> insertUser(@RequestBody User user) {
		logger.info("inserting user ...");
		return ResponseEntity.ok(userRepository.insert(user));
	}

}
