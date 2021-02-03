package com.cybersoft.nhom7.service;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.TaskCategoryDto;
import com.cybersoft.nhom7.model.TaskCategory;
import com.cybersoft.nhom7.repository.TaskCategoryRepository;

public class TaskCategoryService {
	TaskCategoryRepository repository;
	
	public TaskCategoryService()
	{
		repository = new TaskCategoryRepository();
	}
	
	public List<TaskCategoryDto> getAllTaskCategory()
	{
		List<TaskCategoryDto> dtos = new ArrayList<TaskCategoryDto>();
		List<TaskCategory> categories = repository.getAllTaskCategory();
		for(TaskCategory category : categories)
		{
			TaskCategoryDto dto = new TaskCategoryDto(category.getId(),category.getName(),category.getDescription());
			dtos.add(dto);
		}
		return dtos;
	}
}
