package com.qin.management.service.employee;

import com.qin.management.mapper.EmployeeMapper;
import com.qin.management.pojo.Employee;
import com.qin.management.pojo.RespPageBean;
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

    /**
     * 验证姓名是否重复
     * True不重复
     * False重复 不可用。
     */
    public boolean checkEmployeeName(Employee employee){
        boolean result = false;

        if (employeeMapper.getEmployeeByName(employee).size() ==0) {
            result = true;
        }

        return result;
    }

    /**
     * 返回 -1 重复
     * 0操作失败
     * 1成功
     */
    @Override
    public int addEmployee(Employee employee) {
        int result = 0;
        if (checkEmployeeName(employee)) {
            //可用
            //添加创建日期
            employee.setCreateTime(LocalDate.now());
            result = employeeMapper.addEmployee(employee);
            mailService.sendMail(employee.getEmail(),"注册提示","您的账号已经在员工管理系统中生效！");
        }else {
            result = -1;
        }
        return result;
    }

    @Override
    public int add100Emp(Employee employee){
        return employeeMapper.addEmployee(employee);
    }

    /**
     * 返回:
     * -1 要删除的对象不存在
     * 0 删除失败
     * 大于0 删除成功
     */
    @Override
    public int deleteEmployee(int id) {
        Integer result = null;
        //判断对象是否存在
        Employee employee = employeeMapper.getEmployeeById(id);
        if (employee == null){
            result = -1;
        }else {
            result = employeeMapper.deleteEmployee(id);
        }
        return result;
    }
    /**
     * 返回:
     * -1 要删除的对象不存在
     * -2 删除的id集合为空
     * 0 删除失败
     * 大于0 删除成功
     */
    @Override
    public int deleteAll(List<Integer> ids) {
        Integer result = null;
        //判断集合是否为空
        if (ids == null || ids.size() == 0){
            result = -2;
        }else {
            List<Employee> employeeList = employeeMapper.getEmployeeListByIdsList(ids);
            if (employeeList.size() != ids.size()){
                return -1;
            }else {
                result = employeeMapper.deleteAll(ids);
                if (result != ids.size()){
                    result = 0;
                }
            }
        }
        return result;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.getEmployeeList();
    }

    @Override
    public RespPageBean getEmpByPage(Integer page, Integer size) {
        if(page!=null&&size!=null){
            page=(page-1)*size;
        }
        List<Employee> data=employeeMapper.getEmpByPage(page,size);
        Long total=employeeMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @Override
    public Long getTotal() {
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeeByName(Employee employee) {
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
