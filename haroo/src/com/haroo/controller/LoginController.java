package com.haroo.controller;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.action.login.LoginAction;
import com.haroo.action.login.LoginFormAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/login", "/main"})
public class LoginController extends HttpServlet {
    private Action action;
    private ActionForward actionForward;

    public LoginController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        if (requestURI.equals("/login")) action = new LoginFormAction();
        try {
            actionForward = action.execute(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (actionForward != null) {
            if (actionForward.isRedirect()) response.sendRedirect(actionForward.getPath());
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(actionForward.getPath());
                requestDispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        if (requestURI.equals("/main")) action = new LoginAction();
        try {
            actionForward = action.execute(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (actionForward != null) {
            if (actionForward.isRedirect()) response.sendRedirect(actionForward.getPath());
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(actionForward.getPath());
                requestDispatcher.forward(request, response);
            }
        }
    }
}
