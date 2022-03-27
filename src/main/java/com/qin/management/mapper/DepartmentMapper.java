package com.qin.management.mapper;

import com.qin.management.pojo.Department;
import com.qin.management.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> getDepartmentList();

    /**
     * 删除部门
     **/
    int deleteDepartment(int id);

    int addDepartment(Department department);

    int updateDepartment(Department department);

    Department getDepartmentById(int id);
}
