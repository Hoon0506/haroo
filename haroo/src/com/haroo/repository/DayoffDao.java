package com.haroo.repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.DayoffVO;
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
	public DayoffVO listDayoff (int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		DayoffVO dayoff = null;
		
		try {
			dayoff = sqlSession.getMapper(DayoffMapper.class).listDayoff(emNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return dayoff;
	}
	
	//사용일수
	public int updateUseDayoff (int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(DayoffMapper.class).updateUseDayoff(emNo);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
	
	//잔여일수
	public int updateRemainderDayoff (int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(DayoffMapper.class).updateRemainderDayoff(emNo);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
	

}
