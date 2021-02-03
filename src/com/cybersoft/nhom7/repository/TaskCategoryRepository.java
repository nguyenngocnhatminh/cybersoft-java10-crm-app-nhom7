package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.TaskCategory;

public class TaskCategoryRepository {
	public List<TaskCategory> getAllTaskCategory()
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from TASK_CATEGORY";
		List<TaskCategory> taskcategories = new ArrayList<TaskCategory>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				TaskCategory category = new TaskCategory();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				taskcategories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskcategories;
	}
}
