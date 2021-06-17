package com.qin.management.service.admin;

import com.qin.management.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    boolean adminLogin(Admin admin);
    List<Admin> getAdminList();
}
