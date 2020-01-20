package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface UserService {
	 public User save(User u);
	 public List<User> getAllUser();
	 public User getById(int id);
	 public User update(User u,int id);
		public void delete(int[] id);
 public void mapUserIdWithroleID(int userId, int[] roleId);
 public void deleteUserIdAndroleId(int userId, int[] roleId);
 public Set<Role> findRoleIdbyUserId(int userId);

}
