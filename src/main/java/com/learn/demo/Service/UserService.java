package com.learn.demo.Service;

import com.learn.demo.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(long theId);

    public User save(User theUser);

    public void deleteById(long theId);
}
