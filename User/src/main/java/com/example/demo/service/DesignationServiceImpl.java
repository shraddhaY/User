package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Designation;
import com.example.demo.repository.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService{

	@Autowired
	DesignationRepository designationRepository;
	
	@Transactional
	@Override
	public Designation save(Designation designation) {
		// TODO Auto-generated method stub
		return  designationRepository.save(designation);
		
	}

	@Override
	public Designation update(int id, Designation designation) {
		// TODO Auto-generated method stub
		Designation d=designationRepository.findById(id).get();
		d.setDesignationId(designation.getDesignationId());
		d.setDesignationName(designation.getDesignationName());
		return designationRepository.save(d);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		designationRepository.deleteById(id);
	}

	@Override
	public Designation findDesignationById(int id) {
		Designation d=designationRepository.findById(id).get();
		return d;
	}

}
