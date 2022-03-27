package com.qin.management.service.department;

import com.qin.management.pojo.Department;
import com.qin.management.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DepartmentService {
    List<Department> getDepartmentList();

    int deleteDepartment(int id);

    int addDepartment(Department department);

    int updateDepartment(Department department);

    Department getDepartmentById(int id);
}
