package com.haroo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haroo.domain.AttendanceVO;
import com.haroo.repository.AttendanceDao;


public class AttendanceService {
	private static AttendanceService service = new AttendanceService();
	private static AttendanceDao dao;
	
	//서비스 객체와 dao 객체 얻어오는 메소드
	public static AttendanceService getInstance() {
		dao = AttendanceDao.getInstance();
		return service;
	}
	
	//출근(날짜, 사번, 출근시간) 입력 메소드
	public int insertStartTimeService(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		AttendanceVO attendance = new AttendanceVO();
		
		if(session.getAttribute("emNo") != null) {
		      int emNo = (int)session.getAttribute("emNo");
		      attendance.setEmNo(emNo);
		}

		return dao.insertStartTime(attendance);
	}
	
	//퇴근시간 업데이트 메소드
	public int updateEndTimeService(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int re = -1;
		if(session.getAttribute("emNo") != null) {
		      int emNo = (int)session.getAttribute("emNo");
	    	  re = dao.updateEndTime(emNo);
		      
		}
		return re;
	}
	
	//외근 입력 (현재날짜, 사번, 출/퇴근시간, 근무상태:3)
	public int insertOutsideService(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		AttendanceVO attendance = new AttendanceVO();
		
		if(session.getAttribute("emNo") != null) {
		      int emNo = (int)session.getAttribute("emNo");
		      attendance.setEmNo(emNo);
		}
		
		return dao.insertOutside(attendance);
	}
	
	//휴가 데이터 입력 (현재날짜, 사번, 근무상태:4) ------------> 조회활 때 넣어지도록 ListAction에 넣기
	public int insertDayoffService(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		AttendanceVO attendance = new AttendanceVO();
		
		if(session.getAttribute("emNo") != null) {
		      int emNo = (int)session.getAttribute("emNo");
		      attendance.setEmNo(emNo);
		}
		return dao.insertDayoff(attendance);
	}
	
	
	
	
	
	//일별 근태목록조회
	public List<AttendanceVO> statusAttendanceService(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		List<AttendanceVO> list = null;
		
		
		if(session.getAttribute("emNo") != null) {
		      int emNo = (int)session.getAttribute("emNo");
		      
		      AttendanceVO attendance = new AttendanceVO();
		      attendance.setEmNo(emNo);
		      attendance.setAtState(dao.updateState(emNo)); 
		      attendance.setAtNote(dao.updateNote(emNo));
		      
		      list = dao.statusAttendance(attendance);
		      
		}
		return list;
	}
				
				
}
