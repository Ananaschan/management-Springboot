package com.qin.management.mapper;

import com.qin.management.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    /**
     * 添加用户
     **/
    int addEmployee(Employee user);

    /**
     * 删除用户
     **/
    int deleteEmployee(int id);

    /**
     * 查询用户列表
     **/
    List<Employee> getEmployeeList();

    /**
     * 得到单个用户
     **/
    Employee getEmployeeById(int id);


    Employee getEmployeeByName(Employee user);

    /**
     * 关键字查询
     **/
    List<Employee> getEmployeeByKey(Employee user);

    /**
     *修改用户信息
     **/
    int updateEmployee(Employee user);

    Employee EmployeeLogin(Employee user);
}
