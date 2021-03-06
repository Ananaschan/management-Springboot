package com.qin.management.service.employee;

import com.qin.management.pojo.Employee;
import com.qin.management.pojo.RespPageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    /**
     * 添加用户
     **/
    int addEmployee(Employee employee);
    int add100Emp(Employee employee);

    /**
     * 删除用户
     **/
    int deleteEmployee(int id);

    int deleteAll(@Param("ids") List<Integer> ids);
    /**
     * 查询用户列表
     **/
    List<Employee> getEmployeeList();
    RespPageBean getEmpByPage(Integer page, Integer size);
    Long getTotal();
    /**
     * 得到单个用户
     **/
    Employee getEmployeeById(int id);


    List<Employee> getEmployeeByName(Employee employee);

    /**
     * 关键字查询
     **/
    List<Employee> getEmployeeByKey(Employee employee);

    /**
     *修改用户信息
     **/
    int updateEmployee(Employee employee);

    Employee employeeLogin(Employee employee);

}
