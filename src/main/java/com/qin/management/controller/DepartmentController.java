package com.qin.management.controller;

import com.qin.management.pojo.Department;
import com.qin.management.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dep")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentServiceImpl;

    @ResponseBody
    @RequestMapping("/list")
    public List<Department> getDepartmentList(){
        return departmentServiceImpl.getDepartmentList();
    }


}
