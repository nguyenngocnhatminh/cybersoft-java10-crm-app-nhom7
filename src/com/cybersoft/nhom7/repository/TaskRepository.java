package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.TaskDto;
import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.Task;

public class TaskRepository {

	public List<TaskDto> getAllTaskByProjectId(int projectid)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*,b.description as categorydes, c.username, c.avatar as useravatar"
				+ " from TASK a"
				+ " join TASK_CATEGORY b on a.categoryId = b.id "
				+ " join USER c on a.userId = c.id"
				+ " where projectId = ?";
		List<TaskDto> tasks = new ArrayList<TaskDto>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, projectid);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				TaskDto task = new TaskDto();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDescription(rs.getString("description"));
				task.setStartdate(rs.getDate("startdate"));
				task.setEnddate(rs.getDate("enddate"));
				task.setProjectid(rs.getInt("projectId"));
				task.setUserid(rs.getInt("userId"));
				task.setCreateuserid(rs.getInt("createUserId"));
				task.setStatusid(rs.getInt("statusId"));
				task.setCategoryid(rs.getInt("categoryId"));
				task.setCategorydes(rs.getString("categorydes"));
				task.setUsername(rs.getString("username"));
				task.setUseravatar(rs.getString("useravatar"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	public TaskDto getAllTaskByTaskId(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select a.*,b.description as categorydes, c.username, c.avatar as useravatar"
				+ " from TASK a"
				+ " join TASK_CATEGORY b on a.categoryId = b.id "
				+ " join USER c on a.userId = c.id"
				+ " where a.id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				TaskDto task = new TaskDto();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDescription(rs.getString("description"));
				task.setStartdate(rs.getDate("startdate"));
				task.setEnddate(rs.getDate("enddate"));
				task.setProjectid(rs.getInt("projectId"));
				task.setUserid(rs.getInt("userId"));
				task.setCreateuserid(rs.getInt("createUserId"));
				task.setStatusid(rs.getInt("statusId"));
				task.setCategoryid(rs.getInt("categoryId"));
				task.setCategorydes(rs.getString("categorydes"));
				task.setUsername(rs.getString("username"));
				task.setUseravatar(rs.getString("useravatar"));
				return task;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int save(Task task)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Insert into TASK(name,description,startdate,enddate,projectId,userId,statusId,categoryId,createUserId) values (?,?,?,?,?,?,?,?,?)";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, task.getName());
			statement.setString(2, task.getDescription());
			statement.setDate(3, task.getStartdate());
			statement.setDate(4, task.getEnddate());
			statement.setInt(5, task.getProjectid());
			statement.setInt(6, task.getUserid());
			statement.setInt(7, task.getStatusid());
			statement.setInt(8, task.getCategoryid());
			statement.setInt(9, task.getCreateuserid());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int edit(Task task)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Update TASK set name = ?, description = ?, startDate = ? ,endDate = ?, projectId = ?, userId = ?,statusId = ?, categoryId = ? where id = ?";
		System.out.println(query);
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, task.getName());
			statement.setString(2, task.getDescription());
			statement.setDate(3, task.getStartdate());
			statement.setDate(4,task.getEnddate());
			statement.setInt(5, task.getProjectid());
			statement.setInt(6, task.getUserid());
			statement.setInt(7, task.getStatusid());
			statement.setInt(8, task.getCategoryid());
			statement.setInt(9, task.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
