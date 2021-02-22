package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.UserDto;
import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.User;

public class UserRepository {
	
	public List<UserDto> getAllUsers()
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*, b.description as roledes from USER a join ROLE b on a.roleid = b.id";
		List<UserDto> dtos = new ArrayList<UserDto>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				UserDto dto = new UserDto();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setAvatar(rs.getString("avatar"));
				dto.setFullname(rs.getString("fullname"));
				dto.setAddress(rs.getString("address"));
				dto.setPhone(rs.getString("phone"));
				dto.setRoleid(rs.getInt("roleId"));
				dto.setRoledes(rs.getString("roledes"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public UserDto getUserById(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from USER where id = ?";
		UserDto user = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				user = new UserDto();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setFullname(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleId"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserDto getUserByUsername(String username)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*,b.name as rolename, b.description as roledes from USER a join ROLE b on a.roleId = b.id where username = ?";
		UserDto user = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				user = new UserDto();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setFullname(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleId"));
				user.setRolename(rs.getString("rolename"));
				user.setRoledes(rs.getString("roledes"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean checkExistAccount(User user)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from USER where username = ? or email = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmail());
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int save(User user)
	{
		Connection connection = MySqlConnection.getConnection();
		if(checkExistAccount(user))
			return -2;
		String query = "Insert into USER(username,password,email,address,fullname,phone,roleId,avatar) values (?,?,?,N?,N?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getFullname());
			statement.setString(6, user.getPhone());
			statement.setInt(7, user.getRoleid());
			statement.setString(8, user.getAvatar());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int edit(User user)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Update USER set email = ?, password = ?,address = N?, fullname = ?, phone = ?, roleId = ?, avatar = ? where id = ?";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getFullname());
			statement.setString(5, user.getPhone());
			statement.setInt(6, user.getRoleid());
			statement.setString(7, user.getAvatar());
			statement.setInt(8, user.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "delete from USER where id = ?";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
