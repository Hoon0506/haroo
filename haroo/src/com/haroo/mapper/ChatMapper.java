package com.haroo.mapper;

import java.util.List;

import com.haroo.domain.ChatVO;
import com.haroo.domain.EmployeeVO;
import com.haroo.domain.FileVO;

public interface ChatMapper {
	int uploadFile(FileVO fileVO);
	List<FileVO> listFile();
	int insertChat(ChatVO chatVO);
}