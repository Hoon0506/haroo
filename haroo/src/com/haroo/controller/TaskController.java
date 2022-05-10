package com.haroo.controller;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
<<<<<<< HEAD:haroo/src/com/haroo/controller/TaskController.java
import com.haroo.action.task.TaskFormAction;
import com.haroo.action.task.TaskSaveAction;
=======
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a:haroo/src/haroo/controller/TaskController.java

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.task.TaskFormAction;

import java.io.IOException;

@WebServlet("/task/*")
public class TaskController extends HttpServlet {

    private Action action;
    private ActionForward actionForward;

    public TaskController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.equals("/haroo/task")) action = new TaskFormAction();
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

        if (requestURI.equals("/task/save")) action = new TaskSaveAction();

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
