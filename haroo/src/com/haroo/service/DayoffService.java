package com.haroo.service;

import com.haroo.domain.Dayoff;
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
	public Dayoff listDayoff (int emNo) throws Exception {
		return dao.listDayoff(emNo);
	}
}
	
	
	
