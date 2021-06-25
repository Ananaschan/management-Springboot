package com.qin.management.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnMessage {
    private Integer code;
    private String message;
    private Map<String,Object> map = new HashMap<String, Object>();

    public static ReturnMessage success(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode(100);
        returnMessage.setMessage("操作成功");
        return returnMessage;
    }

    public static ReturnMessage fail(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode(200);
        returnMessage.setMessage("操作失败");
        return returnMessage;
    }

    public ReturnMessage add(String key, Object value){
        this.getMap().put(key, value);
        return this;
    }
}
