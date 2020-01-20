package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public User save(User u) {
		return userRepository.save(u);
	}

	@Override
	public List<User> getAllUser() {
		return  userRepository.findAll();
		
	}

	@Override
	public User getById(int id) {
		User u=userRepository.findById(id).get();
		return u;
	}

	@Override
	public User update(User u, int id) {
		User user=userRepository.findById(id).get();
		user.setUserName(u.getUserName());
		return userRepository.save(user);
	}

	@Override
	public void delete(int[] id) {
		for (int uid : id) {
			userRepository.deleteById(uid);
		}

	}

	@Override
	public void mapUserIdWithroleID(int userId, int[] roleId) {
		{
			
			List<Integer> rId = new ArrayList<>();
			Set<Role> rl = new HashSet<>();

			User u = userRepository.searchUserId(userId);
			for (int roId : roleId) {
					Role r = roleRepository.searchRoleId(roId);
					if (r == null) {
						rId.add(roId);

					} else {

						rl.add(r);
					}
				}
				if (!rl.isEmpty()) {
					u.getRole().addAll(rl);
					userRepository.save(u);
				}

			
		}
	}

	@Override
	public void deleteUserIdAndroleId(int userId, int[] roleId) {

		List<Integer> roleId1 = new ArrayList<>();
		Set<Role> role = new HashSet<>();

		User user = userRepository.searchUserId(userId);

		for (int rId : roleId) {
			Role r = roleRepository.searchRoleId(rId);
			if (r == null) {
				roleId1.add(rId);
			} else {
				role.add(r);
			}
		}
		if (!role.isEmpty()) {
			for (Role r : role) {
				r.getUser().remove(user);
				user.getRole().remove(r);
			}
			userRepository.save(user);
		}

	}

	@Override
	public Set<Role> findRoleIdbyUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
