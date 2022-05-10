package com.haroo.service;

import com.haroo.domain.EmployeeVO;
import com.haroo.repository.EmployeeDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeService extends HttpServlet {

    private static EmployeeService employeeService = new EmployeeService();
    private static EmployeeDao employeeDao;

    public static EmployeeService getInstance() {
        employeeDao = EmployeeDao.getInstance();
        return employeeService;
    }

    //로그인 서비스 로직
    public EmployeeVO loginEmployeeService(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EmployeeVO employeeVO = new EmployeeVO();

        employeeVO.setEm_no(Integer.parseInt(request.getParameter("em_no")));
        employeeVO.setEm_pw(request.getParameter("em_pw"));

        return employeeDao.loginEmployee(employeeVO);
    }

    //사원 마이페이지 서비스 로직
    public int updateEmployeeService(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EmployeeVO employeeVO = (EmployeeVO)request.getSession().getAttribute("employeeVO");

        employeeVO.setEm_no(Integer.parseInt(request.getParameter("em_no")));
        employeeVO.setEm_phone(request.getParameter("em_phone"));
        employeeVO.setEm_email(request.getParameter("em_email"));
        employeeVO.setEm_pw(request.getParameter("em_pw"));

        return employeeDao.updateEmployee(employeeVO);
    }
}
