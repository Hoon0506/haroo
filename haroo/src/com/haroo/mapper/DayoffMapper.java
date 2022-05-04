package com.haroo.mapper;

import com.haroo.domain.DayoffVO;

public interface DayoffMapper {
	DayoffVO listDayoff(int emNo); //휴가현황 전체 보기
	int updateUseDayoff (int emNo); //사용일수
	int updateRemainderDayoff (int emNo); //잔여일수

}
