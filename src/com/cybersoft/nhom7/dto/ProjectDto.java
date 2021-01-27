package com.cybersoft.nhom7.dto;

import java.sql.Date;

public class ProjectDto {
	private int id;
	private String name;
	private String description;
	private	Date startdate;
	private	Date enddate;
	private int createuser;
	private String createusername;
	public ProjectDto() {
	}
	public ProjectDto(int id, String name, String description, Date startdate, Date enddate, int createuser) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startdate = startdate;
		this.enddate = enddate;
		this.createuser = createuser;
	}
	
	
	public ProjectDto(String name, String description, int createuser) {
		this.name = name;
		this.description = description;
		this.createuser = createuser;
	}
	public ProjectDto(String name, String description, Date startdate, Date enddate, int createuser) {
		this.name = name;
		this.description = description;
		this.startdate = startdate;
		this.enddate = enddate;
		this.createuser = createuser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getCreateuser() {
		return createuser;
	}
	public void setCreateuser(int createuser) {
		this.createuser = createuser;
	}
	public String getCreateusername() {
		return createusername;
	}
	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}
	
}
