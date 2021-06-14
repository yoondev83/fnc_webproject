// LikeyDAO.java (좋아요 추천 디비 접근)

package com.webprj.project_green.dao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;



public class GreenDao {

	private Connection conn;



	public GreenDao() {

		try {

			String dbURL = "jdbc:mysql://localhost:3306/test";

			String dbID = "root";

			String dbPassword = "wlgns930";

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	// userID, userWriteTitle 둘 다 pk, nn 이므로 중복이 불가 !!!

        // 좋아요한 사람들의  데이터베이스 추가 기능

	public int like(String userID, String userWriteTitle, String userIP) {

		String SQL = "INSERT INTO LIKEY VALUES (?, ?, ?)";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, userID);

			pstmt.setString(2, userWriteTitle);

			pstmt.setString(3, userIP);

			

			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return -1; 

	}
}