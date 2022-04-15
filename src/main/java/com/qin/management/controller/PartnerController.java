package com.qin.management.controller;

import com.qin.management.pojo.Partner;
import com.qin.management.service.partner.PartnerServiceImpl;
import com.qin.management.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {
    @Autowired
    public PartnerServiceImpl partnerService;


    @RequestMapping("/list")
    @ResponseBody
    List<Partner> getPartnerList(){
        List<Partner> list = partnerService.getPartnerList();
        return list;
    }



    //删除partner
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ReturnMessage deletePartner(@PathVariable("id") Integer id) {
        try {
            int i = partnerService.deletePartner(id);
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
    public ReturnMessage addPartner(@Valid @RequestBody Partner partner, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //数据存在不合法的情况
            HashMap<String, Object> map = new HashMap<>();
            for ( FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ReturnMessage.fail().add("fieldError",map);
        }else {
            if (partnerService.addPartner(partner) >0) {
                return ReturnMessage.success();
            }else
                return ReturnMessage.fail();
        }
    }

    @RequestMapping("/update")
    public int updatePartner(@RequestBody Partner partner){
        return partnerService.updatePartner(partner);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public Partner getPartnerById(int id) {
        return partnerService.getPartnerById(id);
    }

}
