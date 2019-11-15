package com.learn.demo.Service;

import com.learn.demo.Dao.NewsDao;
import com.learn.demo.Entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    private NewsDao newsDao;

    @Autowired
    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    @Transactional
    public List<News> getAll() {
        List<News> newsList = new ArrayList<>();
        newsDao.findAll().forEach(newsList::add);
        return newsList;
    }

    @Override
    @Transactional
    public News save(News news) {
        newsDao.save(news);
        return news;
    }

    @Override
    @Transactional
    public void deleteById(String theId) {
        newsDao.deleteById(theId);
    }

    @Override
    @Transactional
    public News findById(String theId) {

        return newsDao.findById(theId).get();
    }

}
