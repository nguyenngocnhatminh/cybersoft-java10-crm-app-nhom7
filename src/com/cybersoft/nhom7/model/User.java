package com.cybersoft.nhom7.model;

import com.cybersoft.nhom7.dto.UserDto;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String fullname;
	private String phone;
	private int roleid;
	private String avatar;
	public User() {
	}
	public User(int id, String username, String password, String email, String address, String fullname, String phone,
			int roleid,String avatar) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.fullname = fullname;
		this.phone = phone;
		this.roleid = roleid;
		this.avatar = avatar;
	}
	public User(String username, String password, String email, String address, String fullname, String phone,
			int roleid, String avatar) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.fullname = fullname;
		this.phone = phone;
		this.roleid = roleid;
		this.avatar = avatar;
	}
	
	public User(UserDto dto)
	{
		this.id = dto.getId();
		this.username = dto.getUsername();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.fullname = dto.getFullname();
		this.phone = dto.getPhone();
		this.roleid = dto.getRoleid();
		this.address = dto.getAddress();
		this.avatar = dto.getAvatar();
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
