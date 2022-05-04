package com.haroo.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.ApLineEmpVO;
import com.haroo.domain.ApprovalLineVO;
import com.haroo.domain.ApprovalVO;
import com.haroo.domain.ExpenseListVO;
import com.haroo.domain.LeaveVO;
import com.haroo.mapper.ApprovalMapper;

public class ApprovalDao {
  private static ApprovalDao dao = new ApprovalDao();
  
  public ApprovalDao() {}
  
  public static ApprovalDao getInstance() {
    return dao;
  }
  
  public SqlSessionFactory getSqlsessionFactory() {
    String resource = "mybatis-config.xml";
    InputStream in = null;
    
    try {
      in = Resources.getResourceAsStream(resource);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return new SqlSessionFactoryBuilder().build(in);
  }
  
  // 상신-진행목록
  public List<ApprovalVO> listProcess(int emNo) {
    List<ApprovalVO> list = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      list = sqlSession.getMapper(ApprovalMapper.class).listProcess(emNo);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return list;
  }
  
  // 품의목록 저장
  public int insertExpenseList(ExpenseListVO expense) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).insertExpenseList(expense);
      
      if(re>0) {
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
  
  // 휴가신청 저장
  public int insertLeave(LeaveVO leave) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).insertLeave(leave);
      
      if(re>0) {
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
  
  // 전자결재 저장
  public int insertApproval(ApprovalVO approval) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).insertApproval(approval);
      
      if(re>0) {
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
  
  // 결재선 저장
  public int insertApprovalLine(ApprovalLineVO apLine) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).insertApprovalLine(apLine);
      
      if(re>0) {
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
  
  // 결재선 선택창 사원 목록
  public List<ApLineEmpVO> listLineEmployee() {
    List<ApLineEmpVO> list = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      list = sqlSession.getMapper(ApprovalMapper.class).listLineEmployee();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return list;
  }
}
