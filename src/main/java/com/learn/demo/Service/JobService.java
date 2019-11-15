package com.learn.demo.Service;

import com.learn.demo.Entity.Job;

import java.util.List;

public interface JobService {

    public List<Job> findAll();

    public Job findById(long theId);

    public Job save(Job theJob);

    public void deleteById(long theId);
}
