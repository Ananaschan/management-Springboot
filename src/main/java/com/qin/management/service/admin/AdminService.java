package com.qin.management.service.admin;

import com.qin.management.pojo.Admin;
import com.qin.management.pojo.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    boolean adminLogin(Admin admin);
    List<Admin> getAdminList();

    int deleteAdmin(int id);

    int addAdmin(Admin admin);

    int updateAdmin(Admin admin);

    Admin getAdminById(int id);
}
