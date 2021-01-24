package com.cybersoft.nhom7.service;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.RoleDto;
import com.cybersoft.nhom7.model.Role;
import com.cybersoft.nhom7.repository.RoleRepository;

public class RoleService {
	RoleRepository repository;
	
	public RoleService()
	{
		repository = new RoleRepository();
	}
	
	public List<RoleDto> getAllRoles()
	{
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		List<Role> roles = repository.getAllRole();
		for(Role role : roles)
		{
			RoleDto dto = new RoleDto(role);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public RoleDto getRoleById(int id)
	{
		Role role = repository.getRoleById(id);
		RoleDto dto = new RoleDto(role);
		return dto;
	}
	
	public RoleDto getRoleByName(String name)
	{
		Role role = repository.getRoleByName(name);
		RoleDto dto = new RoleDto(role);
		return dto;
	}
	
	public int save(RoleDto dto)
	{
		Role role = new Role(dto);
		return repository.save(role);
	}
	
	public int edit(RoleDto dto)
	{
		Role role = repository.getRoleById(dto.getId());
		role.setName(dto.getName());
		role.setDescription(dto.getDescription());
		return repository.edit(role);
	}
	
	public int delete(int id)
	{
		return repository.delete(id);
	}
}
