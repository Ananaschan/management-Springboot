package com.qin.management.controller;

import com.qin.management.pojo.News;
import com.qin.management.service.news.NewsServiceImpl;
import com.qin.management.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    public NewsServiceImpl newsService;


    @RequestMapping("/list")
    @ResponseBody
    List<News> getNewsList(){
        List<News> list = newsService.getNewsList();
        return list;
    }



    //删除news
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ReturnMessage deleteNews(@PathVariable("id") Integer id) {
        try {
            int i = newsService.deleteNews(id);
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
    public ReturnMessage addNews(@Valid @RequestBody News news, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //数据存在不合法的情况
            HashMap<String, Object> map = new HashMap<>();
            for ( FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ReturnMessage.fail().add("fieldError",map);
        }else {
            if (newsService.addNews(news) >0) {
                return ReturnMessage.success();
            }else
                return ReturnMessage.fail();
        }
    }

    @RequestMapping("/update")
    public int updateNews(@RequestBody News news){
        return newsService.updateNews(news);
    }

    @ResponseBody
    @RequestMapping("/getById")
    public News getNewsById(int id) {
        return newsService.getNewsById(id);
    }

}
