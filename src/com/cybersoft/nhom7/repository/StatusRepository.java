package com.cybersoft.nhom7.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.nhom7.jdbc.MySqlConnection;
import com.cybersoft.nhom7.model.Status;

public class StatusRepository {

	public List<Status> getAllStatus()
	{
		Connection connection = MySqlConnection.getConnection();
		String query = "Select * from STATUS";
		List<Status> status = new ArrayList<Status>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				Status sta = new Status();
				sta.setId(rs.getInt("id"));
				sta.setName(rs.getString("name"));
				sta.setDescription(rs.getString("description"));
				status.add(sta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
