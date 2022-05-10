package com.haroo.action.task;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaskSaveAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        TaskService.getInstance().insertTaskService(request, response);

        actionForward.setPath("/haroo/task");
        actionForward.setRedirect(true);

        return actionForward;
    }
}
