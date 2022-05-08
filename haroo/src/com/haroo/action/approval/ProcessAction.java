package com.haroo.action.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.ApprovalVO;
import com.haroo.service.ApprovalService;

public class ProcessAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {
    ActionForward forward = new ActionForward();
    ApprovalVO approval = null;
    ApprovalService service = ApprovalService.getInstance();
    
    // setAttribute로 저장한 값은 getAttribute로 받아야 한다.
    if(request.getAttribute("id") != null) {
      approval = service.detailApprovalService(request);
    }
    
    request.setAttribute("ap", approval);
    
    forward.setPath("/views/approval/approval-detail.jsp");
    forward.setRedirect(false);
    
    return forward;
  }

}
