package com.haroo.repository;

public class AttendanceDao {
	
	private static AttendanceDao dao = new AttendanceDao();
	
	public static AttendanceDao getInstance() {
		return dao;
	}

}
