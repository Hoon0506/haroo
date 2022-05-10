package com.haroo.mapper;

import com.haroo.domain.DayoffVO;

public interface DayoffMapper {
	DayoffVO listDayoff(int emNo); //휴가현황 전체 보기
	int updateUse (int emNo); //사용일수
	int updateRemainder (int emNo); //잔여일수

}
