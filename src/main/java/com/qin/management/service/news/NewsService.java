package com.qin.management.service.news;

import com.qin.management.pojo.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<News> getNewsList();

    int deleteNews(int id);

    int addNews(News news);

    int updateNews(News news);

    News getNewsById(int id);
}

