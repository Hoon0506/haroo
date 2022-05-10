package com.haroo.action.task;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.TaskVO;
import com.haroo.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TaskFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        List<TaskVO> jsonArray = TaskService.getInstance().getTaskListService(request, response);

        request.getSession().setAttribute("jsonArray", jsonArray);

        actionForward.setPath("/task-form.jsp");
        actionForward.setRedirect(false);

        return actionForward;
    }
}
