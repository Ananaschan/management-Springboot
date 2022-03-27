package com.qin.management.service.department;

import com.qin.management.mapper.DepartmentMapper;
import com.qin.management.pojo.Department;
import com.qin.management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    public DepartmentMapper departmentMapper;

    @Override
    public int deleteDepartment(int id) {
        return departmentMapper.deleteDepartment(id);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }

    @Override
    public int addDepartment(Department department) {
        int result = departmentMapper.addDepartment(department);
        return result;
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }
}
