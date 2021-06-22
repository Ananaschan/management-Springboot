package com.qin.management.service.employee;

import com.qin.management.mapper.EmployeeMapper;
import com.qin.management.pojo.Employee;
import com.qin.management.service.mail.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    public MailServiceImpl mailService;
    @Override
    public int addEmployee(Employee employee) {
        //添加创建日期
        employee.setCreateTime(LocalDate.now());
        //mailService.sendMail(employee.getEmail(),"注册提示","您的账号已经在员工管理系统中生效！");
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }

    @Override
    public int deleteAll(List<Integer> ids) {
        return employeeMapper.deleteAll(ids);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.getEmployeeList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByName(Employee employee) {
        return employeeMapper.getEmployeeByName(employee);
    }

    @Override
    public List<Employee> getEmployeeByKey(Employee employee) {
        return employeeMapper.getEmployeeByKey(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public Employee employeeLogin(Employee employee) {
        return employeeMapper.EmployeeLogin(employee);
    }
}
