package com.haroo.action.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.ApprovalService;

public class PostTakebackAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    ApprovalService service = ApprovalService.getInstance();
    
    service.takebackApprovalService(request);
    
    forward.setPath("/haroo/ap/main");
    forward.setRedirect(true);
    
    return forward;
    
  }

}
