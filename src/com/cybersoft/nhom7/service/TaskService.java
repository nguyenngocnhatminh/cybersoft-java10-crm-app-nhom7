package com.cybersoft.nhom7.service;

import java.util.List;

import com.cybersoft.nhom7.dto.TaskDto;
import com.cybersoft.nhom7.model.Task;
import com.cybersoft.nhom7.repository.TaskRepository;

public class TaskService {

	private TaskRepository repository;
	
	public TaskService()
	{
		repository = new TaskRepository();
	}
	
	public List<TaskDto> getAllTaskByProjectId(int projectid)
	{
		return repository.getAllTaskByProjectId(projectid);
	}
	
	public TaskDto getTaskById(int id)
	{
		return repository.getAllTaskByTaskId(id);
	}
	
	public int save(TaskDto dto)
	{
		Task task = new Task(dto);
		return repository.save(task);
	}
	
	public int edit(TaskDto dto)
	{
		Task task = new Task(getTaskById(dto.getId()));
		task.setName(dto.getName());
		task.setDescription(dto.getDescription());
		task.setStartdate(dto.getStartdate());
		task.setEnddate(dto.getEnddate());
		task.setCategoryid(dto.getCategoryid());
		task.setUserid(dto.getUserid());
		task.setProjectid(dto.getProjectid());
		task.setStatusid(dto.getStatusid());
		return repository.edit(task);
	}
}
