package com.qin.management.controller;

import com.qin.management.pojo.Department;
import com.qin.management.pojo.Employee;
import com.qin.management.service.department.DepartmentService;
import com.qin.management.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    //删除用户
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ReturnMessage deleteDepartment(@PathVariable("id") Integer id) {
        try {
            int i = departmentServiceImpl.deleteDepartment(id);
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

    @RequestMapping("/add")
    @ResponseBody
    public ReturnMessage addDepartment(@Valid @RequestBody Department department, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //数据存在不合法的情况
            HashMap<String, Object> map = new HashMap<>();
            for ( FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ReturnMessage.fail().add("fieldError",map);
        }else {
            if (departmentServiceImpl.addDepartment(department) >0) {
                return ReturnMessage.success();
            }else
                return ReturnMessage.fail();
        }
    }

    @RequestMapping("/update")
    public int updateDepartment(@RequestBody Department department){
        return departmentServiceImpl.updateDepartment(department);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public Department getDepartmentById(int id) {
        return departmentServiceImpl.getDepartmentById(id);
    }


}
