package com.example.demo.service;


import com.example.demo.entity.Designation;


public interface DesignationService {
	public Designation save(Designation designation);

	public Designation update(int id, Designation designation);

	public void delete(int id);
	public Designation findDesignationById(int id);


}
