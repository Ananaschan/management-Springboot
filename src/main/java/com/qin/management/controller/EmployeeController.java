package com.qin.management.controller;

import com.qin.management.pojo.Department;
import com.qin.management.pojo.Employee;
import com.qin.management.pojo.RespPageBean;
import com.qin.management.service.employee.EmployeeService;
import com.qin.management.service.mail.MailServiceImpl;
import com.qin.management.utils.ReturnMessage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
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
    @ResponseBody
    public ReturnMessage addUser(@Valid @RequestBody Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //数据存在不合法的情况
            HashMap<String, Object> map = new HashMap<>();
            for ( FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ReturnMessage.fail().add("fieldError",map);
        }else {
            if (employeeService.addEmployee(employee) >0) {
                return ReturnMessage.success();
            }else
            return ReturnMessage.fail();
        }
    }

    @RequestMapping("/add100")
    public int add100User(){
        Employee employee = new Employee();
        employee.setName("test");
        employee.setDepartment(new Department(1,null,null));
        employee.setSalary((float) 5000.0);
        employee.setEmail("123@qq.com");
        employee.setBirthday(LocalDate.now());
        employee.setCreateTime(LocalDate.now());
        employee.setGander(1);
        int i = 0;
        for (; i < 100; i++) {
            int i1 = employeeService.add100Emp(employee);
            i+= i1;
        }
        System.out.println("创建了"+i+"个员工");
        return i;

    }


    //获取用户列表
    @RequestMapping("/list1")
    @ResponseBody
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @RequestMapping("/list")
    public ReturnMessage getEmpByPage(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "5") Integer size){
//        System.out.println("getEmpByPage start");
//        System.out.println(page);
//        System.out.println(size);
        RespPageBean empByPage = null;
        try {
            empByPage = employeeService.getEmpByPage(page, size);
        }catch (Exception e){
            return ReturnMessage.fail().add("error",e);
        }
        return ReturnMessage.success().add("data",empByPage);
    }

    //关键字查询
    @RequestMapping("/key")
    @ResponseBody
    public List<Employee> getUserByKey(@RequestBody Employee employee) {
        System.out.println("getUserByKey start");
        List<Employee> list = employeeService.getEmployeeByKey(employee);
        //System.out.println(list.toString());
        return list;

    }

    //删除用户
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ReturnMessage deleteUser(@PathVariable("id") Integer id) {
       try {
           int i = employeeService.deleteEmployee(id);
           if (i > 0){
               return ReturnMessage.success();
           }else if (i == 0){
               return ReturnMessage.fail();
           }else {
               ReturnMessage message = new ReturnMessage();
               message.setCode(201);
               message.setMessage("对象不存在");
               return message;
           }
       }catch (Exception e){
           return ReturnMessage.fail().add("error",e);
       }

    }

    @RequestMapping("/deleteAll")
    public ReturnMessage deleteAll(@RequestParam("ids") List<Integer> ids){

        try {
            int i = employeeService.deleteAll(ids);
            if (i > 0){
                return ReturnMessage.success();
            }else if (i == 0){
                return ReturnMessage.fail();
            }else {
                ReturnMessage message = new ReturnMessage();
                message.setCode(201);
                message.setMessage("对象不存在");
                return message;
            }
        }catch (Exception e){
            return ReturnMessage.fail().add("error",e);
        }
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
        System.out.println("updateUser");
        System.out.println(employee.toString());
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping("/repeat/{name}")
    public boolean getEmployeeByName(@PathVariable("name") String name){
        //System.out.println(name);
        Employee employee = new Employee();
        employee.setName(name);
        List<Employee> employeeByName = employeeService.getEmployeeByName(employee);
        //System.out.println(employeeByName);
        if (employeeByName.size() != 0){
            return false;
        }
        return true;
    }

}
