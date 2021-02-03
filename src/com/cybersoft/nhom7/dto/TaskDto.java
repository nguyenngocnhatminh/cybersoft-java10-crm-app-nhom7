package com.cybersoft.nhom7.dto;

import java.sql.Date;

import com.cybersoft.nhom7.model.Task;

public class TaskDto {
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
	private String categorydes;
	private String username;
	private String useravatar;
	private String statusdes;
	private String projectname;
	
	public TaskDto() {
	}

	public TaskDto(String name, String description, Date startdate, Date enddate, int projectid, int userid,
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

	public TaskDto(Task task) {
		this.name = task.getName();
		this.id = task.getId();
		this.description = task.getDescription();
		this.startdate = task.getStartdate();
		this.enddate = task.getEnddate();
		this.projectid = task.getProjectid();
		this.userid = task.getUserid();
		this.createuserid = task.getCreateuserid();
		this.statusid = task.getStatusid();
		this.categoryid = task.getCategoryid();

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

	public String getCategorydes() {
		return categorydes;
	}

	public void setCategorydes(String categorydes) {
		this.categorydes = categorydes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseravatar() {
		return useravatar;
	}

	public void setUseravatar(String useravatar) {
		this.useravatar = useravatar;
	}

	public String getStatusdes() {
		return statusdes;
	}

	public void setStatusdes(String statusdes) {
		this.statusdes = statusdes;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

}
