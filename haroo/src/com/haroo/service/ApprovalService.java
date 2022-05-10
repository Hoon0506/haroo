package com.haroo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haroo.domain.ApLineEmpVO;
import com.haroo.domain.ApprovalLineVO;
import com.haroo.domain.ApprovalVO;
import com.haroo.domain.EmployeeVO;
import com.haroo.domain.ExpenseListVO;
import com.haroo.domain.LeaveVO;
import com.haroo.repository.ApprovalDao;

public class ApprovalService {
  private static ApprovalService service = new ApprovalService();
  
  public ApprovalService() {}
  
  public static ApprovalService getInstance() {
    return service;
  }
 
  
  // 상신취소
  public int takebackApprovalService(HttpServletRequest request) throws Exception {
    ApprovalDao dao = ApprovalDao.getInstance();
    
    int apNo = Integer.parseInt(request.getParameter("apNo"));
    
    return dao.takebackApproval(apNo);
  }
  
  // 결재하기
  public int signApprovalService(HttpServletRequest request) throws Exception {
    ApprovalDao dao = ApprovalDao.getInstance();
    ApprovalLineVO apLine = new ApprovalLineVO();
    
    int re = -1;
    
    request.setCharacterEncoding("UTF-8");
    int apNo = Integer.parseInt(request.getParameter("apNo"));
    int alNo = Integer.parseInt(request.getParameter("alNo"));
    int alStatus = Integer.parseInt(request.getParameter("alStatus"));
    String alComment = request.getParameter("alComment");
    
    apLine.setApNo(apNo); // 결재번호
    apLine.setAlNo(alNo); // 사원번호
    apLine.setAlStatus(alStatus); // 승인여부
    apLine.setAlComment(alComment); // 의견
    
    re = dao.approvalReport(apLine);
    
    if(re != -1) {
     re = dao.updateApprovalStatus(apLine);
    }
    
    return re;
  }
  
  // 문서 내용
  public ApprovalVO detailApprovalService(HttpServletRequest request) throws Exception {
    ApprovalVO approval = null;
    ApprovalDao dao = ApprovalDao.getInstance();
    
    int apNo = Integer.parseInt((String)request.getAttribute("id")); // url로 전달된 결재번호
    
    approval = dao.detailApproval(apNo); // 결재문서
    
    approval.setApLine(dao.detailApLine(apNo)); // 결재선
    
    if(approval.getFoNo() == 2) {
      approval.setExpense(dao.detailExpenseList(apNo)); // 품의목록
    } else if(approval.getFoNo() == 3) {
      approval.setLeave(dao.detailLeave(apNo)); // 휴가
    }
    
    
    return approval;
  }
  
  // 전체문서목록
  public List<ApprovalVO> allApprovalService(HttpServletRequest request) throws Exception{
    ApprovalDao dao = ApprovalDao.getInstance();
    List<ApprovalVO> list = null;
    
    list = dao.listAllApproval();
    
    return list;
  }
  
  //수신-문서 목록
  public List<ApprovalVO> receiveApprovalService(HttpServletRequest request) throws Exception{
    ApprovalDao dao = ApprovalDao.getInstance();
    List<ApprovalVO> list = null;
   
    // 세션에 저장된 사원 번호 불러오기
    HttpSession session = request.getSession();
   
    int alStatus = (int)request.getAttribute("status"); // 상태 저장(url에 따라 구분)
   
    if(session.getAttribute("employeeVO") != null) {
      EmployeeVO employee = (EmployeeVO)session.getAttribute("employeeVO");
      int emNo = employee.getEm_no();
      list = dao.receiveApproval(emNo, alStatus);
    }
    
    return list;
  }
  
  // 상신-문서 목록
  public List<ApprovalVO> listApprovalService(HttpServletRequest request) throws Exception{
    ApprovalDao dao = ApprovalDao.getInstance();
    List<ApprovalVO> list = null;
    
    // 세션에 저장된 사원 번호 불러오기
    HttpSession session = request.getSession();
    
    int apStatus = (int)request.getAttribute("status"); // 상태 저장(url에 따라 구분)
    
    if(session.getAttribute("employeeVO") != null) {
      EmployeeVO employee = (EmployeeVO)session.getAttribute("employeeVO");
      int emNo = employee.getEm_no();
      list = dao.listApproval(emNo, apStatus);
    }
    
    return list;
  }
  
  // 상신하기
  public int postReportService(HttpServletRequest request) throws Exception{
    ApprovalDao dao = ApprovalDao.getInstance();
    ApprovalVO approval = new ApprovalVO(); // 결재문서
    LeaveVO leave = new LeaveVO(); // 휴가신청
    ExpenseListVO expense = new ExpenseListVO(); // 품의목록
    int re = -1;
    
    request.setCharacterEncoding("utf-8");
    
    int foNo=Integer.parseInt(request.getParameter("foNo")); // 문서양식
    int emNo = Integer.parseInt(request.getParameter("emNo")); // 사원번호
    int apPublic = Integer.parseInt(request.getParameter("apPublic")); // 공개여부
    
    if(request.getParameter("apTitle") == null) {
      return re;
    }
    approval.setFoNo(foNo); // 문서양식
    approval.setEmNo(emNo); // 사원번호
    approval.setApTitle(request.getParameter("apTitle")); // 제목
    approval.setApContent(request.getParameter("editordata")); // 내용
    approval.setApPublic(apPublic); // 공개여부
    
    re = dao.insertApproval(approval); // 결재문서 저장
    
    int apNo = approval.getApNo(); // 결재문서번호 저장
    
    if(foNo == 3 && re > 0) { // 양식이 휴가신청서(3) 일 때
      leave.setApNo(apNo); // 결재문서 번호
      leave.setFoNo(foNo); // 양식번호
      leave.setEmNo(emNo); // 사원번호
      leave.setLeTitle(approval.getApTitle()); // 제목
      leave.setLeKind(Integer.parseInt(request.getParameter("leKind"))); // 휴가종류
      leave.setLeStart(request.getParameter("leStart")); // 휴가시작일
      leave.setLeEnd(request.getParameter("leEnd")); // 휴가종료일
      leave.setDaNo(Integer.parseInt(request.getParameter("daNo"))); // 휴가번호
      
      re = dao.insertLeave(leave);
      
    } else if(foNo == 2 && re > 0) { // 양식이 품의서(2) 일 때
      expense.setApNo(apNo); // 결재문서번호
      expense.setElTotal(request.getParameter("elTotal")); // 총금액
      
      for(int i=1; i<=5; i++) { // item은 5개까지 작성 가능
        String item = request.getParameter(("elItem"+i));
        if(item == null || item.equals("")) { // item이 존재하지 않을 때
          break;
        }
        expense.setElNo(i); // 품목번호
        expense.setElItem(item); // 품목
        expense.setElQuantity(Integer.parseInt(request.getParameter(("elQuantity"+i)))); // 수량
        expense.setElPrice(Integer.parseInt(request.getParameter(("elPrice"+i)))); // 가격
        expense.setElCost(request.getParameter(("elCost"+i))); // 소계
        
        re = dao.insertExpenseList(expense);
      }
    }
    
    int alNo = 0; // 결재자 번호
    
    // 결재선 저장하기
    if(re > 0) {
      if(request.getParameter("alNo1") != null) {
        alNo = Integer.parseInt(request.getParameter("alNo1"));
        re = dao.insertApprovalLine(new ApprovalLineVO(apNo, alNo, 1)); // 결재문서번호, 결재권자, 순서
      }
      
      if(request.getParameter("alNo2") != null) {
        alNo = Integer.parseInt(request.getParameter("alNo2"));
        re = dao.insertApprovalLine(new ApprovalLineVO(apNo, alNo, 2));
      } 
      
      if(request.getParameter("alNo3") != null) {
        alNo = Integer.parseInt(request.getParameter("alNo3"));
        re = dao.insertApprovalLine(new ApprovalLineVO(apNo, alNo, 3));
      }
    }
    
    
    
    return re;
  }
  
  // 결재선 선택 창 사원 목록
  public List<ApLineEmpVO> listLineEmployeeService(HttpServletRequest request) throws Exception{
    ApprovalDao dao = ApprovalDao.getInstance();
    List<ApLineEmpVO> list = null;
    

    list = dao.listLineEmployee();

    
    return list;
  }
  
  // 휴가번호 가져오기
  public int getDaNoService(HttpServletRequest request) throws Exception {
    ApprovalDao dao = ApprovalDao.getInstance();
    
    HttpSession session = request.getSession();
    EmployeeVO employee = (EmployeeVO)session.getAttribute("employeeVO");
    
    return dao.getDaNo(employee);
  }
}
