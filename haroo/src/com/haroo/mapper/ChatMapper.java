package com.haroo.mapper;

import com.haroo.domain.ChatVO;
import com.haroo.domain.EmployeeVO;
import com.haroo.domain.FileVO;


public interface ChatMapper {
	int uploadFile(FileVO fileVO);

}