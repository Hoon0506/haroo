package com.haroo.repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.ChatVO;
import com.haroo.domain.FileVO;
import com.haroo.mapper.BoardMapper;
import com.haroo.mapper.ChatMapper;

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
	
	
	
	public List<FileVO> listFileVO() {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<FileVO> list = null;
		try {
			list = sqlSession.getMapper(ChatMapper.class).listFile();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	public int uploadFile(FileVO fileVO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ChatMapper.class).uploadFile(fileVO);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}
}
