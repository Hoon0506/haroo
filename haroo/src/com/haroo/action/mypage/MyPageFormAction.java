package com.haroo.action.mypage;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/mypage-form.jsp");
        actionForward.setRedirect(false);

        return actionForward;
    }
}
