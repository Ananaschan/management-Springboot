package com.qin.management.service.department;

import com.qin.management.pojo.Department;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DepartmentService {
    List<Department> getDepartmentList();
}
