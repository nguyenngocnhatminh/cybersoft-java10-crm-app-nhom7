package com.cybersoft.nhom7.model;

import java.sql.Date;

import com.cybersoft.nhom7.dto.TaskDto;

public class Task {
	private int id;
	private String name;
	private String description;
	private Date startdate;
	private Date enddate;
	private int projectid;
	private int userid;
	private int createuserid;
	private int statusid;
	private int categoryid;
	public Task() {
	}
	public Task(String name, String description, Date startdate, Date enddate, int projectid, int userid,
			int createuserid, int statusid, int categoryid) {
		this.name = name;
		this.description = description;
		this.startdate = startdate;
		this.enddate = enddate;
		this.projectid = projectid;
		this.userid = userid;
		this.createuserid = createuserid;
		this.statusid = statusid;
		this.categoryid = categoryid;
	}
	
	public Task(TaskDto dto)
	{
		this.id = dto.getId();
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.startdate = dto.getStartdate();
		this.enddate = dto.getEnddate();
		this.projectid = dto.getProjectid();
		this.userid = dto.getUserid();
		this.createuserid = dto.getCreateuserid();
		this.statusid = dto.getStatusid();
		this.categoryid = dto.getCategoryid();
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
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCreateuserid() {
		return createuserid;
	}
	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	
}
