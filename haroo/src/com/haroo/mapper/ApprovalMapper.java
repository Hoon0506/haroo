package com.haroo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haroo.domain.ApLineEmpVO;
import com.haroo.domain.ApprovalLineVO;
import com.haroo.domain.ApprovalVO;
import com.haroo.domain.EmployeeVO;
import com.haroo.domain.ExpenseListVO;
import com.haroo.domain.LeaveVO;

public interface ApprovalMapper {
  public int insertApproval(ApprovalVO approval); // 전자결재 저장
  public int insertApprovalLine(ApprovalLineVO apLine); // 결재선 저장
  public int insertLeave(LeaveVO leave); // 휴가신청 저장
  public int insertExpenseList(ExpenseListVO expense); // 품의목록 저장
  public List<ApprovalVO> listApproval(@Param("emNo") int emNo, @Param("apStatus") int apStatus); // 상신-진행 목록
  public List<ApLineEmpVO> listLineEmployee(); // 결재선 선택 창 사원 목록
  public ApprovalVO detailApproval(int apNo); // 결재문서 내용 보기
  public List<ApprovalLineVO> detailApLine(int apNo); // 해당 결재 결재선 불러오기
  public LeaveVO detailLeave(int apNo); // 휴가신청서 내용 불러오기
  public List<ExpenseListVO> detailExpenseList(int apNo); // 품의목록 불러오기
  public int takebackApproval(int apNo); // 상신취소
  public List<ApprovalVO> receiveApproval(@Param("emNo") int emNo, @Param("alStatus") int alStatus); // 수신 목록
  public int approvalReport(ApprovalLineVO apLine); // 결재하기
  public int updateApprovalStatus(ApprovalLineVO apLine); // 결재상태확인
  public int getDaNo(EmployeeVO employee); // 휴가번호 가져오기
}
