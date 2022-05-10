package com.haroo.mapper;

import com.haroo.domain.TaskVO;

import java.util.List;

public interface TaskMapper {
    List<TaskVO> getTaskList(int em_no);
    int insertTask(TaskVO taskVO);
    int updateTask(TaskVO taskVO);
}
