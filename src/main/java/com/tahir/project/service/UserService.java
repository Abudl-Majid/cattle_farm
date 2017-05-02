package com.tahir.project.service;

import com.tahir.project.model.User;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface UserService {
  User save(User User);
  User update(User User);
  void delete(Integer UserId);
  User findByUserId(Integer UserId);
  public List<User> findAll();
}
