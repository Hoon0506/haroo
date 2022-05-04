package com.haroo.action.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;

public class FormAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    
    // setAttribute로 저장한 값은 getAttribute로 받아야 한다.
    int foNo = Integer.parseInt((String)request.getAttribute("id"));
    
    if(foNo==1) {
      forward.setPath("/views/approval/draft-form.jsp");
      forward.setRedirect(false);
    } else if(foNo==2) {
      forward.setPath("/views/approval/expense-form.jsp");
      forward.setRedirect(false);
    } else if(foNo==3) {
      forward.setPath("/views/approval/leave-form.jsp");
      forward.setRedirect(false);
    } // else문에 사용자가 올린 양식을 불러오는 로직을 추가하면 됨
    
    
    
    return forward;
  }

}
