package com.Student_Vtalent.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Student_Vtalent.Bean.Student_details;

public class Dao {
	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;

	public Dao() {
		connection = MySQLConnections.getInstance();
	}

	public int insertDataWithpreparedStatement(Student_details s) {
		int result = 0;
		String query = "insert into student_details values(?,?,?,?,?)";
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, s.getStd_id());
			preparedstatement.setString(2, s.getStd_name());
			preparedstatement.setString(3, s.getStd_branch());
			preparedstatement.setString(4, s.getStd_gender());
			preparedstatement.setString(5, s.getStd_number());
			result = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	public int deleteDataWithpreparedStatement(Student_details s) {
		int result1 = 0;
		String query = "delete from student_details where std_id=?";
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, s.getStd_id());
			result1 = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result1;

	}

	public int updateDataWithpreparedStatement(Student_details s) {
		int result1 = 0;
		String query = "update employee_table set std_name=? where std_id=?";
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, s.getStd_name());
			preparedstatement.setString(1, s.getStd_id());
			result1 = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result1;

	}
}
