package com.learn.demo.Dao;

import com.learn.demo.Entity.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsDao extends CrudRepository<News, String> {

}
