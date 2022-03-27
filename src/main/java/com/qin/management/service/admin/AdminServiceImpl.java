package com.qin.management.service.admin;

import com.qin.management.mapper.AdminMapper;
import com.qin.management.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    public AdminMapper adminMapper;

    @Override
    public boolean adminLogin(Admin admin) {
        Admin login = adminMapper.adminLogin(admin);
        return login != null;
    }

    @Override
    public List<Admin> getAdminList() {
        return adminMapper.getAdminList();
    }

    @Override
    public int deleteAdmin(int id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin getAdminById(int id) {
        return adminMapper.getAdminById(id);
    }
}
