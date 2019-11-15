package com.learn.demo.Dao;

import com.learn.demo.Entity.Job;

import java.util.List;

public interface JobDao {

    public List<Job> findAll();

    public Job findById(long theId);

    public Job save(Job theJob);

    public void deleteById(long theId);
}
