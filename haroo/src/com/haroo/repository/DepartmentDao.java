package com.haroo.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.DepartmentVO;
import com.haroo.mapper.DepartmentMapper;

public class DepartmentDao {

	private static DepartmentDao dao = new DepartmentDao();

	public static DepartmentDao getInstance() {

		return dao;
	}// --end getInstance

	public SqlSessionFactory getSqlSessionFactory() {

		String resource = "mybatis-config.xml";

		InputStream input = null;

		try {

			input = Resources.getResourceAsStream(resource);

		} catch (Exception e) {
			e.printStackTrace();
		} // --end try~catch

		return new SqlSessionFactoryBuilder().build(input);

	}// --end getSqlSessionFactory

	// 부서 목록(메소드명 == Department.xml query문 id)
	public List<DepartmentVO> listDepartment() {

		SqlSession sqlSession = getSqlSessionFactory().openSession();

		List<DepartmentVO> list = null;

		try {

			list = sqlSession.getMapper(DepartmentMapper.class).listDepartment();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // --end try~catch~finally
		return list;

	}// --end listDepartment

}// --end class DepartmentDao
