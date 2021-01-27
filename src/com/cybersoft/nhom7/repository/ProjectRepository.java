package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.ProjectDto;
import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.Project;

public class ProjectRepository {
	
	public List<ProjectDto> getAllProject()
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*,b.username from PROJECT a join USER b on a.createUser = b.id";
		List<ProjectDto> projects = new ArrayList<ProjectDto>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				ProjectDto project = new ProjectDto();
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setStartdate(rs.getDate("startDate"));
				project.setEnddate(rs.getDate("endDate"));
				project.setCreateuser(rs.getInt("createUser"));
				project.setCreateusername(rs.getString("username"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public ProjectDto getProjectById(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*,b.username from PROJECT a join USER b on a.createUser = b.id where a.id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				ProjectDto project = new ProjectDto();
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setStartdate(rs.getDate("startDate"));
				project.setEnddate(rs.getDate("endDate"));
				project.setCreateuser(rs.getInt("createUser"));
				project.setCreateusername(rs.getString("username"));
				return project;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int save(Project project)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Insert into PROJECT(name,description,startdate,enddate,createUser) values (?,?,?,?,?)";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartdate());
			statement.setDate(4, project.getEnddate());
			statement.setInt(5,project.getCreateuser());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int edit(Project project)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Update PROJECT set name = ?, description = ?,startdate = ?, enddate = ? where id = ?";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartdate());
			statement.setDate(4, project.getEnddate());
			statement.setInt(5, project.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "delete from PROJECT where id = ?";
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
