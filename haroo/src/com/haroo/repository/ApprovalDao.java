package com.haroo.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
  
  // 결재 상태 확인 변경
  public int updateApprovalStatus(ApprovalLineVO apLine) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).updateApprovalStatus(apLine);
      
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
  
  // 결재하기
  public int approvalReport(ApprovalLineVO apLine) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).approvalReport(apLine);
      
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
  
  // 결재문서 내용
  public ApprovalVO detailApproval(int apNo) {
    ApprovalVO approval = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      approval = sqlSession.getMapper(ApprovalMapper.class).detailApproval(apNo);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return approval;
  }
  
  // 해당 결재 문서 결재선 목록
  public List<ApprovalLineVO> detailApLine(int apNo) {
    List<ApprovalLineVO> list = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      list = sqlSession.getMapper(ApprovalMapper.class).detailApLine(apNo);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return list;
  }
  //휴가신청서 내용 불러오기
  public LeaveVO detailLeave(int apNo) {
    LeaveVO leave = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      leave = sqlSession.getMapper(ApprovalMapper.class).detailLeave(apNo);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return leave;
  }
  
  //품의목록 불러오기
  public List<ExpenseListVO> detailExpenseList(int apNo) {
    List<ExpenseListVO> list = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      list = sqlSession.getMapper(ApprovalMapper.class).detailExpenseList(apNo);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return list;
  }
  
  // 수신-문서 목록
  public List<ApprovalVO> receiveApproval(int emNo, int alStatus) { // 로그인 사원, 상태에 따라 분류를 위해 파라미터 설정
   List<ApprovalVO> list = null;
   
   SqlSession sqlSession = getSqlsessionFactory().openSession();
   
   try {
     list = sqlSession.getMapper(ApprovalMapper.class).receiveApproval(emNo, alStatus);
     
   } catch (Exception e) {
     e.printStackTrace();
   } finally {
     if(sqlSession != null) {
       sqlSession.close();
     }
   }
   
   return list;
 }
  
  // 상신-문서 목록
  public List<ApprovalVO> listApproval(int emNo, int apStatus) { // 로그인 사원, 상태에 따라 분류를 위해 파라미터 설정
    List<ApprovalVO> list = null;
    
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      list = sqlSession.getMapper(ApprovalMapper.class).listApproval(emNo, apStatus);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(sqlSession != null) {
        sqlSession.close();
      }
    }
    
    return list;
  }
  
  // 상신취소
  public int takebackApproval(int apNo) {
    int re = -1;
    SqlSession sqlSession = getSqlsessionFactory().openSession();
    
    try {
      re = sqlSession.getMapper(ApprovalMapper.class).takebackApproval(apNo);
      
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
