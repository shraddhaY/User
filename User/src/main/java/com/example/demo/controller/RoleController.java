package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping
	public ResponseEntity<Role> createDesignation(@RequestBody Role role) {
		Role r = roleService.save(role);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Role> getId(@PathVariable int id) {
		Role r = roleService.getById(id);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Role> update(@PathVariable int id, @RequestBody Role role) {

		Role r = roleService.update(id, role);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int[] id) {
		roleService.delete(id);
	}

	@PostMapping(value = "/{roleId}/role/{userId}")
	public ResponseEntity<Void> mapRoleIdWithUserId(@PathVariable int roleId,@PathVariable int[] userId) {
		roleService.mapRoleIdWithUserID(roleId, userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{roleId}/userRole/{userId}")
	public ResponseEntity<Void> deleteRoleIdAndUserIdMapping(@PathVariable int roleId, @PathVariable int[] userId) {
		roleService.deleteRoleIdAndUserIdMapping(roleId,userId);
		return new ResponseEntity<>(HttpStatus.OK);

		}


}
