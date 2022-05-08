package com.haroo.repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FileDAO {
	private Connection conn;
	
	private static FileDAO dao = new FileDAO();
	
	public static FileDAO getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int upload(String contentsName, String contentsRealName) {
		String sql = "INSERT INTO FILE VALUES (?, ?)";
		 try {
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = null;
			 pstmt.setString(1, contentsName);
			 pstmt.setString(2, contentsRealName);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return -1;
	}
}
