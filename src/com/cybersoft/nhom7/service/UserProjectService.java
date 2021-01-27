package com.cybersoft.nhom7.service;

import java.util.List;

import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.repository.UserProjectRepository;

public class UserProjectService {

	private UserProjectRepository repository;
	
	public UserProjectService()
	{
		repository = new UserProjectRepository();
	}
	
	public List<UserProjectDto> getAllUserProjectByProjectId(int id)
	{
		return repository.getUserProjectByProjectId(id);
	}
}
