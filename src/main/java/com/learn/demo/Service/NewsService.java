package com.learn.demo.Service;

import com.learn.demo.Entity.News;

import java.util.List;

public interface NewsService {

    List<News> getAll();

    News save(News news);

    public void deleteById(String theId);

    public News findById(String theId);

}
