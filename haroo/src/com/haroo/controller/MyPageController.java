package com.haroo.controller;

<<<<<<< HEAD:haroo/src/com/haroo/controller/MyPageController.java
import com.haroo.action.mypage.MyPageAction;
import com.haroo.action.mypage.MyPageFormAction;
=======
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a:haroo/src/haroo/controller/MyPageController.java
import com.haroo.action.Action;
import com.haroo.action.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.mypage.MyPageAction;
import com.haroo.action.mypage.MyPageFormAction;

import java.io.IOException;

@WebServlet("/mypage/*")
public class MyPageController extends HttpServlet {

    private Action action;
    private ActionForward actionForward;

    public MyPageController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.equals("/haroo/mypage")) action = new MyPageFormAction();
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

        if (requestURI.equals("/haroo/mypage/update-information")) action = new MyPageAction();

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
