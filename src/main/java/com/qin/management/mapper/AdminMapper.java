package com.qin.management.mapper;

import com.qin.management.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AdminMapper {
    Admin adminLogin(Admin admin);
    List<Admin> getAdminList();
    int deleteAdmin(int id);

    int addAdmin(Admin admin);

    int updateAdmin(Admin admin);

    Admin getAdminById(int id);
}
