package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User u=userService.save(user);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable int id,@RequestBody User u) {
		User u1=userService.update(u, id);
		return new ResponseEntity<>(u1, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(int []id){
		userService.delete(id);
	return null;
	}
	
	@PostMapping(value = "/{userId}/userRole/{roleId}")
	public ResponseEntity<Void> mapUserIdAndRoleIdMapping(@PathVariable int userId, @PathVariable int [] roleId) {
		userService.mapUserIdWithroleID(userId, roleId);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	@DeleteMapping(value = "/{userId}/userRole/{roleId}")
	public ResponseEntity<Void> deleteUserIdAndRoleIdMapping(@PathVariable int userId, @PathVariable int[] roleId) {
		userService.deleteUserIdAndroleId(userId, roleId);
		return new ResponseEntity<>(HttpStatus.OK);

		}

	
}
