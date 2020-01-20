package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Role save(Role r) {
		// TODO Auto-generated method stub
		return roleRepository.save(r);
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role getById(int id) {
		// TODO Auto-generated method stub
		Role r = roleRepository.findById(id).get();
		return r;
	}

	@Override
	public Role update(int id, Role role) {
		Role r = roleRepository.findById(id).get();

		r.setRoleId(role.getRoleId());
		r.setName(role.getName());
		return roleRepository.save(r);
	}

	@Override
	public void delete(int[] id) {
		// TODO Auto-generated method stub
		for (int rid : id) {
			roleRepository.deleteById(rid);
		}
	}

	@Override
	public void mapRoleIdWithUserID(int roleId, int[] userId) {

		
		List<Integer> us = new ArrayList<>();
		Role r = roleRepository.searchRoleId(roleId);
		
			for (int uId : userId) {
				User user = userRepository.searchUserId(uId);
				if (user == null) {
					us.add(uId);
				} else {
					user.getRole().add(r);
					userRepository.save(user);
				}
			}
		

	}

	@Override
	public void deleteRoleIdAndUserIdMapping(int roleId, int[] userId) {

		List<Integer> use = new ArrayList<>();

		Role r = roleRepository.searchRoleId(roleId);

		for (int uId : userId) {

			User u = userRepository.searchUserId(uId);

			if (u == null) {
				use.add(uId);
			} else {
				u.getRole().remove(r);
				r.getUser().remove(u);
				userRepository.save(u);
			}
		}

	}

}
