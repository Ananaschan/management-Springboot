package com.qin.management.service.department;

import com.qin.management.mapper.DepartmentMapper;
import com.qin.management.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    public DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }
}
