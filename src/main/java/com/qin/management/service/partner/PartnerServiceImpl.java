package com.qin.management.service.partner;

import com.qin.management.mapper.PartnerMapper;
import com.qin.management.pojo.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService{
    @Autowired
    public PartnerMapper partnerMapper;


    @Override
    public List<Partner> getPartnerList() {
        return partnerMapper.getPartnerList();
    }

    @Override
    public int deletePartner(int id) {
        return partnerMapper.deletePartner(id);
    }

    @Override
    public int addPartner(Partner partner) {
        return partnerMapper.addPartner(partner);
    }

    @Override
    public int updatePartner(Partner partner) {
        return partnerMapper.updatePartner(partner);
    }

    @Override
    public Partner getPartnerById(int id) {
        return partnerMapper.getPartnerById(id);
    }

}
