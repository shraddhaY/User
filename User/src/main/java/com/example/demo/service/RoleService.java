package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface RoleService {
	public Role save(Role r);
	 public List<Role> getAllRole();
	 public Role getById(int id);
	 public Role update(int id,Role u);

	public void delete(int[] id);

	public void mapRoleIdWithUserID(int roleId, int[] userId);

	public void deleteRoleIdAndUserIdMapping(int roleId, int[] userId);

	
}
