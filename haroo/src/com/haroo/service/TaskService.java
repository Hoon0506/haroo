package com.haroo.service;

import com.haroo.domain.EmployeeVO;
import com.haroo.domain.TaskVO;
import com.haroo.repository.TaskDao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

public class TaskService extends HttpServlet {

    private static TaskService taskService = new TaskService();
    private static TaskDao taskDao;

    public static TaskService getInstance() {
        taskDao = TaskDao.getInstance();
        return taskService;
    }

    //기존 일정 가져오기 서비스 로직
    public JSONArray getTaskListService(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int em_no = ((EmployeeVO)request.getSession().getAttribute("employeeVO")).getEm_no();

        //JSON 객체 담는 그릇
        JSONArray jsonArray = new JSONArray();

        //SELECT해서 가져온 일정들
        List<TaskVO> taskVOList = taskDao.getTaskList(em_no);

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        //TaskVO to JSON
        if (!taskVOList.isEmpty()) {
            for (TaskVO taskVO : taskVOList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", taskVO.getId());
                jsonObject.put("groupId", taskVO.getGroupId());
                jsonObject.put("title", taskVO.getTitle());
                jsonObject.put("writer", taskVO.getWriter());
                jsonObject.put("content", taskVO.getContent());
                jsonObject.put("start", taskVO.getStart());
                jsonObject.put("end", taskVO.getEnd());
                jsonObject.put("allday", taskVO.isAllday());
                jsonObject.put("backgroundColor", taskVO.getBackgroundColor());
                jsonObject.put("textColor", taskVO.getTextColor());
                jsonObject.put("borderColor", taskVO.getBorderColor());
                jsonObject.put("em_no", taskVO.getEm_no());

                jsonArray.add(jsonObject);
            }
        }

        return jsonArray;
    }

    //일정 추가 서비스 로직
    public int insertTaskService(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8");

        TaskVO taskVO = new TaskVO();

//        taskVO.setId(Integer.parseInt(request.getParameter("id")));
        taskVO.setGroupId("1");
        taskVO.setTitle(request.getParameter("title"));
        taskVO.setWriter("hong");
        taskVO.setContent("to final");
        taskVO.setStart(request.getParameter("start"));
        taskVO.setEnd(request.getParameter("end"));
        taskVO.setAllday(Boolean.parseBoolean(request.getParameter("allDay")));
        taskVO.setBackgroundColor(request.getParameter("backgroundColor"));
        taskVO.setTextColor(request.getParameter("textColor"));
        taskVO.setBorderColor("blue");
        taskVO.setEm_no(((EmployeeVO)request.getSession().getAttribute("employeeVO")).getEm_no());

        return taskDao.insertTask(taskVO);
    }
}
