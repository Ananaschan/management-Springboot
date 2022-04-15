package com.qin.management.mapper;

import com.qin.management.pojo.News;
import com.qin.management.pojo.Partner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsMapper {
    List<News> getNewsList();
    int deleteNews(int id);

    int addNews(News news);

    int updateNews(News news);

    News getNewsById(int id);
}
