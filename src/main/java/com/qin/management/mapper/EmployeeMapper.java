package com.qin.management.mapper;

import com.qin.management.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    int deleteAll(@Param("ids") List<Integer> ids);
    /**
     * 查询用户列表
     **/
    List<Employee> getEmployeeList();

    List<Employee> getEmployeeListByIdsList(@Param("ids")List<Integer> ids);

    List<Employee> getEmpByPage(@Param("page") Integer page,@Param("size") Integer size);

    Long getTotal();

    /**
     * 得到单个用户
     **/
    Employee getEmployeeById(int id);


    List<Employee> getEmployeeByName(Employee user);

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
