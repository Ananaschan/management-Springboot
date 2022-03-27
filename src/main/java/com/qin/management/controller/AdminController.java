package com.qin.management.controller;

import com.qin.management.pojo.Admin;
import com.qin.management.pojo.Department;
import com.qin.management.service.admin.AdminService;
import com.qin.management.service.admin.AdminServiceImpl;
import com.qin.management.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    public AdminServiceImpl adminService;

    @RequestMapping("/login")
    boolean adminLogin(@RequestBody Admin admin){
        System.out.println(admin.toString());
        boolean login = adminService.adminLogin(admin);
        System.out.println(login);
        return login;
    }

    @RequestMapping("/list")
    @ResponseBody
    List<Admin> getAdminList(){
        List<Admin> list = adminService.getAdminList();
        return list;
    }



    //删除用户
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ReturnMessage deleteAdmin(@PathVariable("id") Integer id) {
        try {
            int i = adminService.deleteAdmin(id);
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
    public ReturnMessage addAdmin(@Valid @RequestBody Admin admin, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //数据存在不合法的情况
            HashMap<String, Object> map = new HashMap<>();
            for ( FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ReturnMessage.fail().add("fieldError",map);
        }else {
            if (adminService.addAdmin(admin) >0) {
                return ReturnMessage.success();
            }else
                return ReturnMessage.fail();
        }
    }

    @RequestMapping("/update")
    public int updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public Admin getAdminById(int id) {
        return adminService.getAdminById(id);
    }

}
