package com.qin.management.service.partner;

import com.qin.management.pojo.Partner;

import java.util.List;

public interface PartnerService {
    List<Partner> getPartnerList();

    int deletePartner(int id);

    int addPartner(Partner partner);

    int updatePartner(Partner partner);

    Partner getPartnerById(int id);
}
