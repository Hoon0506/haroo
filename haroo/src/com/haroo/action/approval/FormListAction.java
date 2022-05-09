package com.haroo.action.approval;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;

public class FormListAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    // 나중에 사용자가 올린 양식 포함한 리스트를 불러와야 함
    forward.setPath("/views/approval/form-list.jsp");
    forward.setRedirect(false);
    
    return forward;
  }

}
