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
import com.cybersoft.nhom7.model.UserProject;

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
	
	public List<ProjectDto> getAllProjectByProjectUser(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "select b.*, c.username from USER_PROJECT a"
				+ " join PROJECT b on a.projectId = b.id "
				+ " join USER c on b.createUser = c.id"
				+ " where userId = ? ";
		List<ProjectDto> projects = new ArrayList<ProjectDto>();
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
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public List<ProjectDto> getAllProjectByUser(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*,b.username from PROJECT a join USER b on a.createUser = b.id where a.createuser = ?";
		List<ProjectDto> projects = new ArrayList<ProjectDto>();
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
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartdate());
			statement.setDate(4, project.getEnddate());
			statement.setInt(5,project.getCreateuser());
			statement.executeUpdate();
			
			String sql = "select LAST_INSERT_ID() as id";
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int projectid = 0;
			while(rs.next())
			{
				projectid = rs.getInt("id");
				break;
			}
			
			UserProjectRepository userprojectrepo = new UserProjectRepository();
			UserProject userproject = new UserProject(projectid,project.getCreateuser(),project.getStartdate(),"ROLE_LEADER");
			if(userprojectrepo.saveAfterSaveProject(userproject,connection) < 1)
			{
				return -1;
			}
			connection.commit();
			connection.setAutoCommit(true);
			return 1;

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
			connection.setAutoCommit(false);
			String sql = "delete from USER_PROJECT where projectId = ?";
			PreparedStatement statementSql = connection.prepareStatement(sql);
			statementSql.setInt(1, id);
			statementSql.executeUpdate();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			if(statement.executeUpdate() < 1)
				return -1;
			connection.commit();
			connection.setAutoCommit(true);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
