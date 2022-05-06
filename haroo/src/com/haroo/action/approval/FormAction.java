package com.haroo.action.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.ApprovalService;

public class FormAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    ApprovalService service = ApprovalService.getInstance();
    
    // setAttribute로 저장한 값은 getAttribute로 받아야 한다.
    int foNo = Integer.parseInt((String)request.getAttribute("id"));
    
    request.setAttribute("daNo", service.getDaNoService(request)); // 휴가번호 저장
    
    if(foNo==1) { // 기안서
      forward.setPath("/views/approval/draft-form.jsp");
      forward.setRedirect(false);
    } else if(foNo==2) { // 품의서
      forward.setPath("/views/approval/expense-form.jsp");
      forward.setRedirect(false);
    } else if(foNo==3) { // 휴가신청서
      forward.setPath("/views/approval/leave-form.jsp");
      forward.setRedirect(false);
    } // else문에 사용자가 올린 양식을 불러오는 로직을 추가하면 됨
    
    
    
    return forward;
  }

}
