package com.tahir.project.service.impl;


import com.tahir.project.dao.UserDao;
import com.tahir.project.model.User;
import com.tahir.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService{

  @Autowired
  UserDao dao;

  @Override
  public User save(User User) {
    return dao.save(User);
  }

  @Override
  public User update(User User) {
    return dao.update(User);
  }

  @Override
  public void delete(Integer UserId) {
    dao.delete(UserId);
  }

  @Override
  public User findByUserId(Integer UserId) {
    return dao.findByUserId(UserId);
  }

  @Override
  public List<User> findAll() {
    return dao.findAll();
  }
}
