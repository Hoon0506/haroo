package com.haroo.mapper;

import com.haroo.domain.EmployeeVO;

public interface EmployeeMapper {
    EmployeeVO loginEmployee(EmployeeVO employeeVO);
    int updateEmployee(EmployeeVO employeeVO);
}
