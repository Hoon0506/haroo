package haroo.mapper;

import haroo.domain.EmployeeVO;

public interface EmployeeMapper {
    EmployeeVO loginEmployee(EmployeeVO employeeVO);
    int updateEmployee(EmployeeVO employeeVO);
}
