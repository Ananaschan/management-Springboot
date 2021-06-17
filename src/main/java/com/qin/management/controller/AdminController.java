package com.qin.management.controller;

import com.qin.management.pojo.Admin;
import com.qin.management.service.admin.AdminService;
import com.qin.management.service.admin.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
