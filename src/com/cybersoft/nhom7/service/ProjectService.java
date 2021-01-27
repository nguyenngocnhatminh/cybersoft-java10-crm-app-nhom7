package com.cybersoft.nhom7.service;

import java.util.List;


import com.cybersoft.nhom7.dto.ProjectDto;
import com.cybersoft.nhom7.model.Project;
import com.cybersoft.nhom7.repository.ProjectRepository;

public class ProjectService {

	private ProjectRepository repository;
	
	public List<ProjectDto> getAllProjects(){
		return repository.getAllProject();
	}
	
	public List<ProjectDto> getAllProjectsByUser(int id)
	{
		return repository.getAllProjectByUser(id);
	}
	
	public ProjectDto getProjectByID(int id)
	{
		return repository.getProjectById(id);
	}
	
	public ProjectService()
	{
		repository = new ProjectRepository();
	}
	
	public int save(ProjectDto dto)
	{
		Project project = new Project(dto);
		return repository.save(project);
	}
	
	public int edit(ProjectDto dto)
	{
		Project project = new Project(repository.getProjectById(dto.getId()));
		project.setName(dto.getName());
		project.setDescription(dto.getDescription());
		project.setStartdate(dto.getStartdate());
		project.setEnddate(dto.getEnddate());
		return repository.edit(project);
	}
	
	public int delete(int id)
	{
		return repository.delete(id);
	}
}
