package com.haroo.repository;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.Dayoff;
import com.haroo.mapper.DayoffMapper;

public class DayoffDao {
private static DayoffDao dao = new DayoffDao();
	
	public static DayoffDao getInstance() {
		return dao;
	}
	
	//SqlSessionFactory 메소드
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
	
	//휴가현황 출력
	public Dayoff listDayoff (int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Dayoff dayoff = null;
		
		try {
			dayoff = sqlSession.getMapper(DayoffMapper.class).listDayoff(emNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return dayoff;
	}
	
	

}
