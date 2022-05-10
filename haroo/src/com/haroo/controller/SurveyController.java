package com.haroo.controller;


import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.survey.dao.SurveyDAO;
import com.haroo.survey.dto.SurveyDTO;
import com.haroo.survey.dto.SurveyResultDTO;
import com.haroo.survey.dto.SurveySummaryDTO;



@WebServlet("/survey/*")
public class SurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SurveyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String url = request.getRequestURI();
		SurveyDAO dao = new SurveyDAO();
		
		if(url.indexOf("input.do") != -1) {
			SurveyDTO dto = dao.viewQuestion(1); 
			request.setAttribute("dto", dto); 
			
	
			String page = "/survey/survey_input.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.indexOf("insert.do") != -1) {
			
			int survey_num = Integer.parseInt(request.getParameter("survey_num"));
		
			int num = Integer.parseInt(request.getParameter("num"));
			
			
			SurveyResultDTO dto = new SurveyResultDTO();
			dto.setSurvey_um(survey_num);
			dto.setNum(num);
			
			
			dao.insertSurvey(dto);
			response.sendRedirect(path + "/survey_servlet/survey_result.do?survey_num=2");
			
		} else if(url.indexOf("survey_result.do") != -1) {
			System.out.println("asd");
			int survey_num = Integer.parseInt(request.getParameter("survey_num"));
			List<SurveySummaryDTO> items = dao.listSummary(survey_num);
			request.setAttribute("list", items);
			
	
			String page = "/survey/survey_result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
