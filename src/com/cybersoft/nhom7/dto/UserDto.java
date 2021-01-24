package com.cybersoft.nhom7.dto;

public class UserDto {
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String fullname;
	private String phone;
	private int roleid;
	private String avatar;
	
	
	
	public UserDto() {
		username = "";
		password = "";
		address = "";
		fullname = "";
		phone = "";
		roleid = 1;
		avatar = "/assets/images/avatars/default.jpg";
	}
	
	public UserDto(String username, String password, String email, String address, String fullname, String phone,
			int roleid) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.fullname = fullname;
		this.phone = phone;
		this.roleid = roleid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	private String rolename;
	private String roledes;
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
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledes() {
		return roledes;
	}
	public void setRoledes(String roledes) {
		this.roledes = roledes;
	}
	
	
}
