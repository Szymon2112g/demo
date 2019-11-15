package com.learn.demo.Service;

import com.learn.demo.Dao.UserDao;
import com.learn.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findById(long theId) {
        return userDao.findById(theId).get();
    }

    @Override
    @Transactional
    public User save(User theUser) {
        userDao.save(theUser);
        return theUser;
    }

    @Override
    @Transactional
    public void deleteById(long theId) {
        userDao.deleteById(theId);
    }
}
