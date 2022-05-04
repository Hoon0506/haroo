package com.haroo.action.approval;

import java.util.List;

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
    ApprovalService service = ApprovalService.getInstance();
    
    List<ApprovalVO> list = service.listProcessService(request);
    
    request.setAttribute("list", list);
    
    forward.setPath("/views/approval/process-list.jsp");
    forward.setRedirect(false);
    
    return forward;
  }

}
