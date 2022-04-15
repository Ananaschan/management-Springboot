package com.qin.management.mapper;

import com.qin.management.pojo.Admin;
import com.qin.management.pojo.Partner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PartnerMapper {
    List<Partner> getPartnerList();
    int deletePartner(int id);

    int addPartner(Partner partner);

    int updatePartner(Partner partner);

    Partner getPartnerById(int id);
}
