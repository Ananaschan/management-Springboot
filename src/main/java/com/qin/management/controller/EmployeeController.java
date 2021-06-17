package com.qin.management.controller;

import com.qin.management.pojo.Employee;
import com.qin.management.service.employee.EmployeeService;
import com.qin.management.service.mail.MailServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;



    //用户注销
    @RequestMapping("/logout")
    public String logout(){
          return "ok";
    }

    //添加员工
    @RequestMapping("/add")
    public int addUser(@RequestBody Employee employee){
        if (employeeService.getEmployeeByName(employee) != null){
            return 0;
        }
        return employeeService.addEmployee(employee);
    }

    //获取用户列表
    @RequestMapping("/list")
    @ResponseBody
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    //关键字查询
    @RequestMapping("/key")
    @ResponseBody
    public List<Employee> getUserByKey(@RequestBody Employee employee) {
        System.out.println("getUserByKey start");
        List<Employee> list = employeeService.getEmployeeByKey(employee);
        System.out.println(list.toString());
        return list;

    }

    //删除用户
    @RequestMapping("/delete")
    public int deleteUser(Integer id) {
        return employeeService.deleteEmployee(id);
    }

    //根据id查用户
    @ResponseBody
    @RequestMapping("/getById")
    public Employee getUserById(int id) {
        return employeeService.getEmployeeById(id);
    }

    //修改用户信息
    @RequestMapping("/update")
    public int updateUser(@RequestBody Employee employee){
        System.out.println(employee.toString());
        return employeeService.updateEmployee(employee);
    }

}