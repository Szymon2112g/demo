package com.learn.demo.Service;

import com.learn.demo.Dao.JobDao;
import com.learn.demo.Dao.UserDao;
import com.learn.demo.Entity.Job;
import com.learn.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobServiceImpl(JobDao jobDao) {
        this.jobDao = jobDao;
    }


    @Override
    @Transactional
    public List<Job> findAll() {
        return jobDao.findAll();
    }

    @Override
    @Transactional
    public Job findById(long theId) {
        return jobDao.findById(theId);
    }

    @Override
    @Transactional
    public Job save(Job theJob) {
        return jobDao.save(theJob);
    }

    @Override
    @Transactional
    public void deleteById(long theId) {
        jobDao.deleteById(theId);
    }
}
