package com.haroo.repository;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.AttendanceVO;
import com.haroo.domain.EmployeeVO;
import com.haroo.mapper.AttendanceMapper;

public class AttendanceDao {

	private static AttendanceDao dao = new AttendanceDao();

	public static AttendanceDao getInstance() {
		return dao;
	}

	// SqlSessionFactory 메소드
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

	//출근 입력
	public int insertStartTime(AttendanceVO attendance) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AttendanceMapper.class).insertStartTime(attendance);
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
	
	//퇴근시간 데이터 값 변경
	public int updateEndTime(int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AttendanceMapper.class).updateEndTime(emNo);
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
	
	//외근 데이터 입력
	public int insertOutside(AttendanceVO attendance) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AttendanceMapper.class).insertOutside(attendance);
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
	
	//9시 이전 출근 = 근무상태 : 1 (정상)
//	public int updateStateNormal(int emNo) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = -1;
//
//		try {
//			re = sqlSession.getMapper(AttendanceMapper.class).updateStateNormal(emNo);
//			if (re > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//		return re;
//	}
//	
//	//9시 이후 출근 = 근무상태 : 2 (지각)
//	public int updateStateTardiness(int emNo) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = -1;
//
//		try {
//			re = sqlSession.getMapper(AttendanceMapper.class).updateStateTardiness(emNo);
//			if (re > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//		return re;
//	}
	
	///근무상태 변경
	public int updateState(int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AttendanceMapper.class).updateState(emNo);
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
	
	
	//휴가 데이터 입력
	public int insertDayoff() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AttendanceMapper.class).insertDayoff();
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
	
	//휴가 => 비고 값 업데이트
	public int updateNote(int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AttendanceMapper.class).updateNote(emNo);
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
	
	
	//일별 근태목록조회
	public List<AttendanceVO> statusAttendance(AttendanceVO attendance) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<AttendanceVO> list = null;

		try {
			list = sqlSession.getMapper(AttendanceMapper.class).statusAttendance(attendance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	//로그인한 사람의 부서목록
	public List<AttendanceVO> listDept(int emNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<AttendanceVO> list = null;

		try {
			list = sqlSession.getMapper(AttendanceMapper.class).listDept(emNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	//오늘날짜
	public String printToday() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String str = null;

		try {
			str = sqlSession.getMapper(AttendanceMapper.class).printToday();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return str;
	}

}
