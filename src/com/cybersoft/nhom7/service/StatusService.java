package com.cybersoft.nhom7.service;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.StatusDto;
import com.cybersoft.nhom7.model.Status;
import com.cybersoft.nhom7.repository.StatusRepository;

public class StatusService {
	StatusRepository repository;
	
	public StatusService()
	{
		repository = new StatusRepository();
	}
	
	public List<StatusDto> getAllStatus()
	{
		List<StatusDto> dtos = new ArrayList<StatusDto>();
		List<Status> status = repository.getAllStatus();
		for(Status sta : status)
		{
			StatusDto dto = new StatusDto(sta.getId(),sta.getName(),sta.getDescription());
			dtos.add(dto);
		}
		return dtos;
	}
	
	public String getStatusDataToggle()
	{
		String data = "[";
		List<StatusDto> dtos = getAllStatus();
		for(int i = 0; i <dtos.size(); i++)
		{
			data += "\"#trello-tasks-"+dtos.get(i).getId()+"\"";
			if(i!=dtos.size()-1)
			{
				data+=", ";
			}
		}
		data+="]";
		return data;
	}
}
