package com.qin.management.service.news;

import com.qin.management.mapper.NewsMapper;
import com.qin.management.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    public NewsMapper newsMapper;


    @Override
    public List<News> getNewsList() {
        return newsMapper.getNewsList();
    }

    @Override
    public int deleteNews(int id) {
        return newsMapper.deleteNews(id);
    }

    @Override
    public int addNews(News news) {
        return newsMapper.addNews(news);
    }

    @Override
    public int updateNews(News news) {
        return newsMapper.updateNews(news);
    }

    @Override
    public News getNewsById(int id) {
        return newsMapper.getNewsById(id);
    }

}
