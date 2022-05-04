package com.haroo.action.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;

public class MainAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    
    HttpSession session = request.getSession();
    session.setAttribute("emNo", 45424411);
    session.setAttribute("emName", "백민주");
    session.setAttribute("daNo", 124);
    
    // 나중에 사용자가 올린 양식 포함한 리스트를 불러와야 함
    forward.setPath("/views/approval/main.jsp");
    forward.setRedirect(false);
    
    return forward;
  }

}
