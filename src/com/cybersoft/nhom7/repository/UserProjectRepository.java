package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.ProjectDto;
import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.jdbc.MySqlConnection;

public class UserProjectRepository {

	public List<UserProjectDto> getUserProjectByProjectId(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "select * from USER a left join (select * from USER_PROJECT where projectId = ?) as b on a.id = b.userId order by b.projectId desc";
		List<UserProjectDto> projects = new ArrayList<UserProjectDto>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				UserProjectDto project = new UserProjectDto();
				project.setProjectid(rs.getInt("projectId"));
				project.setUserid(rs.getInt("id"));
				project.setJoinDate(rs.getDate("joinDate"));
				project.setRole(rs.getString("role"));
				project.setUsername(rs.getString("username"));
				project.setUseremail(rs.getString("email"));
				project.setUserfullname(rs.getString("fullname"));
				project.setAvatar(rs.getString("avatar"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
}
