package com.haroo.repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.BoardVO;
import com.haroo.mapper.BoardMapper;

public class BoardDao {
	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	// sqlsessionfactory�� �������� ���
	public SqlSessionFactory getSqlSessionFactory() {
		// mybatis-config.xml => SqlsessionFactory ��ȯ
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource); //Resources�� ibatis��
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//�Խ��� �� ���
	public int insertBoard(BoardVO board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			//re = sqlSession.insert("kosta.mapper.BoardMapper.insertBoard", board); //row�� ������ ����
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);;
			if(re>0) { //insert, update, delete�� Ʈ����� ó���� �ؾ��Ѵ�. spring������ ���� ���⼭
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
}
