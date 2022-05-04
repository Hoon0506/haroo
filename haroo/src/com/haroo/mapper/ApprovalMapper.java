package com.haroo.mapper;

import java.util.List;

import com.haroo.domain.ApLineEmpVO;
import com.haroo.domain.ApprovalLineVO;
import com.haroo.domain.ApprovalVO;
import com.haroo.domain.ExpenseListVO;
import com.haroo.domain.LeaveVO;

public interface ApprovalMapper {
  public int insertApproval(ApprovalVO approval); // 전자결재 저장
  public int insertApprovalLine(ApprovalLineVO apLine); // 결재선 저장
  public int insertLeave(LeaveVO leave); // 휴가신청 저장
  public int insertExpenseList(ExpenseListVO expense); // 품의목록 저장
  public List<ApprovalVO> listProcess(int emNo); // 상신-진행 목록
  public List<ApLineEmpVO> listLineEmployee(); // 결재선 선택 창 사원 목록
  
}
