package com.haroo.mapper;

import java.util.List;

import com.haroo.domain.AttendanceVO;
import com.haroo.domain.EmployeeVO;

public interface AttendanceMapper {
	int insertStartTime(AttendanceVO attendance); //출근 입력 (현재날짜, 사번, 출근시간)
	int updateEndTime(int emNo); //퇴근시간 업데이트
	int insertOutside(AttendanceVO attendance); //외근 입력 (현재날짜, 사번, 출/퇴근시간, 근무상태:3)
	
	//int updateStateNormal(int emNo); 	//9시 이전 출근 = 근무상태 : 1 (정상)
	//int updateStateTardiness(int emNo); //9시 이후 출근 = 근무상태 : 2 (지각)
	
	int updateState(int emNo); //근무상태 업데이트 (정상/지각)
	
	int insertDayoff(); //휴가인 사람 입력 (현재날짜, 사번, , 근무상태:4)
	int updateNote(int emNo); //휴가 => 비고 값 업데이트
	
	
	List<AttendanceVO> statusAttendance(AttendanceVO attendance); //일별 근태조회
	List<AttendanceVO> listDept(int emNo); //로그인한 사람의 부서목록
	String printToday(); //오늘날짜
	
	

}
