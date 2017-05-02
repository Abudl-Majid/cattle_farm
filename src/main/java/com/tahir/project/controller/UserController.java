package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.User;
import com.tahir.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<User> listUsers(ModelMap model) {

    List<User> Users = service.findAll();
    model.addAttribute("Users", Users);
    return Users;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody User  saveUser(@RequestBody User User) {
    service.save(User);
    return User;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody User  updateUser(@RequestBody User User) {
    service.update(User);
    return User;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{User_id}" }, method = RequestMethod.GET)
  public @ResponseBody User  getUser(@PathVariable("User_id") Integer User_id) {
    return service.findByUserId(User_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{User_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteUser(@PathVariable("User_id") Integer User_id) {
    service.delete(User_id);
  }

}
