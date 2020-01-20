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

import com.example.demo.entity.Designation;
import com.example.demo.service.DesignationService;

@RestController
@RequestMapping(value = "/designation")
public class DesignationController {

	@Autowired
	DesignationService designationService;
	
	@PostMapping
	public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation){
		Designation d=designationService.save(designation);
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Designation> getId(@PathVariable int id){
		Designation d=designationService.findDesignationById(id);
	  return new ResponseEntity<>(d,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Designation> update(@PathVariable int id,@RequestBody Designation designation){
		
		Designation d=designationService.update(id, designation) ;
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		designationService.delete(id);
	}
}
