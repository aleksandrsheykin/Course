package com.company.planning.models.dao;

import com.company.planning.models.pojo.User;

import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public interface UserDao {
    public List<User> getAll();
    public User get(int id);
    public boolean update(User user);
    public boolean delete(User user);
}
