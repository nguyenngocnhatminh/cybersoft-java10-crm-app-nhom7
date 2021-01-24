package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.Role;

public class RoleRepository {
	
	public List<Role> getAllRole()
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from ROLE";
		List<Role> roles = new ArrayList<Role>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	
	public Role getRoleByName(String name)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from ROLE where name = ?";
		Role role = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public Role getRoleById(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from ROLE where id = ?";
		Role role = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public int save(Role role)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Insert into ROLE(name,description) values (?,N?)";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int edit(Role role)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Update ROLE set name = ?, description = ? where id = ?";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "delete from ROLE where id = ?";
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
