package com.cybersoft.nhom7.service;

import org.mindrot.jbcrypt.BCrypt;

import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.model.User;
import com.cybersoft.nhom7.repository.RoleRepository;
import com.cybersoft.nhom7.repository.UserRepository;

public class AuthService {
	private UserRepository repository;
	private RoleRepository rolerepository;
	
	public AuthService()
	{
		repository = new UserRepository();
		rolerepository = new RoleRepository();
	}
	
	public UserDto Login(String username,String password)
	{
		UserDto dto = repository.getUserByUsername(username);
		if(dto == null)
		{
			return null;
		}
		if (!BCrypt.checkpw(password,dto.getPassword() ))
			return null;
		return dto;
	}
	
	public int SignUp(UserDto dto)
	{
		int id = rolerepository.getRoleByName("ROLE_MEMBER").getId();
		dto.setRoleid(id);
		User user = new User(dto);
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
		return repository.save(user);
	}
}
