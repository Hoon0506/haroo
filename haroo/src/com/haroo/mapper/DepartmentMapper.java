package com.haroo.mapper;

import java.util.List;

import com.haroo.domain.DepartmentVO;

public interface DepartmentMapper {
	
	//이름==mapper query문 id
	List<DepartmentVO> listDepartment();//전체 부서
}// --end interface DepartmentMapper
