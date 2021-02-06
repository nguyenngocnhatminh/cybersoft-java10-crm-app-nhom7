package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.dto.UserProjectDto;
import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.UserProject;

public class UserProjectRepository {

	public List<UserProjectDto> getAllUserByProjectId(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "select * from USER a "
				+ "left join (select * from USER_PROJECT where projectId = ?) as b on a.id = b.userId	"
				+ "join ROLE c on a.roleId = c.id	"
				+ "where c.name = 'ROLE_MEMBER'"
				+ " order by b.projectId desc";
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
	
	public List<UserProjectDto> getUserProjectByProjectByProjectId(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		String query ="select a.projectId,a.userId,b.avatar , b.username,b.fullname, c.name as projectname "
				+ "from USER_PROJECT a "
				+ "join USER b on a.userId = b.id "
				+ "join PROJECT c on a.projectId = c.id "
				+ "where a.projectId = ?";
		List<UserProjectDto> projects = new ArrayList<UserProjectDto>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				UserProjectDto project = new UserProjectDto();
				project.setProjectid(rs.getInt("projectId"));
				project.setUserid(rs.getInt("userId"));
				project.setUsername(rs.getString("username"));
				project.setUserfullname(rs.getString("fullname"));
				project.setProjectname(rs.getString("projectname"));
				project.setAvatar(rs.getString("avatar"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public int saveAfterSaveProject(UserProject user, Connection connection)
	{
		String query = "insert into USER_PROJECT values (?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, user.getProjectid());
			statement.setInt(2, user.getUserid());
			statement.setDate(3, user.getJoinDate());
			statement.setString(4, user.getRole());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int save(List<UserProject> dtos)
	{
		Connection connection = MySqlConnection.getConnection();
		try {
			connection.setAutoCommit(false);
			if(deleteBeforeUpdate(dtos.get(0).getProjectid(),connection) < 0)
				return -1;
			for (UserProject userProjectDto : dtos) {
				String query = "insert into USER_PROJECT values (?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, userProjectDto.getProjectid());
				statement.setInt(2, userProjectDto.getUserid());
				statement.setDate(3, userProjectDto.getJoinDate());
				statement.setString(4, userProjectDto.getRole());
				statement.executeUpdate();
			}
			connection.commit();
			connection.setAutoCommit(true);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int deleteBeforeUpdate(int id, Connection connection)
	{
		String query = "delete from USER_PROJECT where projectId = ?";
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
	
	public int delete(int id)
	{
		Connection connection = MySqlConnection.getConnection();
		return deleteBeforeUpdate(id, connection);
	}
}
