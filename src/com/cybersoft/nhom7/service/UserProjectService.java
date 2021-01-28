package com.cybersoft.nhom7.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.model.UserProject;
import com.cybersoft.nhom7.repository.UserProjectRepository;

public class UserProjectService {

	private UserProjectRepository repository;
	
	public UserProjectService()
	{
		repository = new UserProjectRepository();
	}
	
	public List<UserProjectDto> getAllUserByProjectId(int id)
	{
		return repository.getAllUserByProjectId(id);
	}
	
	public List<UserProjectDto> getAllUserProjectByProjectId(int id)
	{
		return repository.getUserProjectByProjectByProjectId(id);
	}
	
	public List<UserProjectDto> ParseToUserProjectDto(String[] userid,int projectId,String[] joindates,String[] roles)
	{
		List<UserProjectDto> dtos = new ArrayList<UserProjectDto>();
		for(int i = 0 ;i<userid.length;i++)
		{
			UserProjectDto dto = new UserProjectDto();
			dto.setProjectid(projectId);
			dto.setUserid(Integer.parseInt(userid[i]));
			if(!joindates[i].equals(""))
			{
				Date joindate = java.sql.Date.valueOf(joindates[i]);
				dto.setJoinDate(joindate);
			}
			dto.setRole(roles[i]);
			dtos.add(dto);
		}	
		return dtos;
	}
	
	public int save(List<UserProjectDto> dtos)
	{
		List<UserProject> userprojects = new ArrayList<UserProject>();
		for (UserProjectDto dto : dtos) {
			UserProject userProject = new UserProject(dto.getProjectid(),dto.getUserid(),dto.getJoinDate(),dto.getRole());
			userprojects.add(userProject);
		}
		return repository.save(userprojects);
	}
	
	public int delete(int id)
	{
		return repository.delete(id);
	}
}
