package com.haroo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haroo.domain.DayoffVO;
import com.haroo.repository.DayoffDao;

public class DayoffService {
	private static DayoffService service = new DayoffService();
	private static DayoffDao dao;
	
	//서비스 객체와 dao 객체 얻어오는 메소드
	public static DayoffService getInstance() {
		dao = DayoffDao.getInstance();
		return service;
	}
	
	//휴가현황 출력
	public DayoffVO listDayoffService (HttpServletRequest request) throws Exception {
		//1. 승인여부 값 가져오기 (휴가신청 테이블) 	
		//2. 승인여부 값 수정 (휴가 테이블)	
		//3. 휴가 일수 값 계산
	
		DayoffVO dayoff = new DayoffVO();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("emNo") != null) {
		      int emNo = (int)session.getAttribute("emNo");
		      
		      dayoff.setDaCnt(dao.updateUse(emNo)); //사용일수
		      dayoff.setDaRemainder(dao.updateRemainder(emNo)); //잔여일수
		      dayoff = dao.listDayoff(emNo);
		    }
		
		return dayoff;
		//return null;
	}
	
}
	
	
	
