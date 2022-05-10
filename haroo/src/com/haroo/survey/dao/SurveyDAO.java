package com.haroo.survey.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.survey.dto.SurveyDTO;
import com.haroo.survey.dto.SurveyResultDTO;
import com.haroo.survey.dto.SurveySummaryDTO;
import com.haroo.survey.mapper.SurveyMapper;

public class SurveyDAO {
	public SqlSessionFactory getSqlSessionFactory() {
		//mybatis-config.xml  => SqlSesstionFactory 변환
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}	
	
	/*
	 * public SurveyDTO viewQuestion(int survey_num) {
	 * 
	 * SqlSession sqlSession = getSqlSessionFactory().openSession();
	 * 
	 * 
	 * SurveyDTO dto = sqlSession.selectOne("survey.view_question", survey_num);
	 * sqlSession.close(); return dto; }
	 */
	public  SurveyDTO view_question(int survey_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		
		SurveyDTO dto=null;
		try {
			dto= sqlSession.getMapper(SurveyMapper.class).view_question(survey_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dto;
		
	}
	
	public void insertSurvey(SurveyResultDTO dto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		sqlSession.insert("survey.insert_survey", dto); 
		sqlSession.commit();
		sqlSession.close();
	}

	public List<SurveySummaryDTO> listSummary(int survey_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<SurveySummaryDTO> items = sqlSession.selectList("survey.list_summary", survey_num);
		sqlSession.close();
		return items;
	}

	public static Object classgetInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
