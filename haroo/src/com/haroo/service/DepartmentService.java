package com.haroo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.domain.DepartmentVO;
import com.haroo.repository.DepartmentDao;

public class DepartmentService {

	private static DepartmentService service = new DepartmentService();
	private static DepartmentDao dao;

	public static DepartmentService getInstance() {

		dao = DepartmentDao.getInstance();

		return service;

	}// --end getInstance

	public List<DepartmentVO> listDepartment(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();

		//List<DepartmentVO> list = dao.listDepartment();

		/*
		 * if (session.getAttribute("deNo") != null) { int deNo = (int)
		 * session.getAttribute("deNo"); }
		 */

		
		  List<DepartmentVO> list = null;
		  list = dao.listDepartment();
		/*
		 * DepartmentVO departmentVO =
		 * (DepartmentVO)request.getSession().getAttribute("deaprtmentVO");
		 * departmentVO.setDeNo(Integer.parseInt(request.getParameter("de_no")));
		 * departmentVO.setDeName(request.getParameter("de_name"));
		 * list.add(departmentVO);
		 */
		 
		return list;

	}
}// --end Class DepartmentService
