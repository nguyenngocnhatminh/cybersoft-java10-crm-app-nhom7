package com.cybersoft.nhom7.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.model.User;
import com.cybersoft.nhom7.repository.UserRepository;

public class UserService {
	private UserRepository repository;

	public UserService() {
		this.repository = new UserRepository();
	}
	
	public List<UserDto> getAllUsers()
	{
		return repository.getAllUsers();
	}
	
	public UserDto getUserById(int id)
	{
		return repository.getUserById(id);
	}
	
	public int save(UserDto dto)
	{
		User user = new User(dto);
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
		return repository.save(user);
	}
	
	public int edit(UserDto dto)
	{
		User user = new User(repository.getUserById(dto.getId()));
		user.setEmail(dto.getEmail());
		if(dto.getPassword()!= "")
		{
			user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
		}
		user.setAddress(dto.getAddress());
		user.setFullname(dto.getFullname());
		user.setPhone(dto.getPhone());
		user.setAvatar(dto.getAvatar());
		user.setRoleid(dto.getRoleid());
		return repository.edit(user);
	}
	
	public int delete(int id)
	{
		return repository.delete(id);
	}
}
