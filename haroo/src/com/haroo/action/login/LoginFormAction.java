package com.haroo.action.login;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/login-form.jsp");
        actionForward.setRedirect(false);

        return actionForward;
    }
}
