package com.cybersoft.nhom7.model;

import java.sql.Date;

public class UserProject {
	private int projectid;
	private int userid;
	private Date joinDate;
	private String role;
	public UserProject() {
	}
	public UserProject(int projectid, int userid, Date joinDate, String role) {
		super();
		this.projectid = projectid;
		this.userid = userid;
		this.joinDate = joinDate;
		this.role = role;
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
