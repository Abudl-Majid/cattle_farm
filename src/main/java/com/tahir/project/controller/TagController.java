package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Tag;
import com.tahir.project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

  @Autowired
  TagService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Tag> listTags(ModelMap model) {

    List<Tag> Tags = service.findAll();
    model.addAttribute("Tags", Tags);
    return Tags;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Tag  saveTag(@RequestBody Tag Tag) {
    service.save(Tag);
    return Tag;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Tag  updateTag(@RequestBody Tag Tag) {
    service.update(Tag);
    return Tag;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Tag_id}" }, method = RequestMethod.GET)
  public @ResponseBody Tag  getTag(@PathVariable("Tag_id") Integer Tag_id) {
    return service.findByTagId(Tag_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Tag_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteTag(@PathVariable("Tag_id") Integer Tag_id) {
    service.delete(Tag_id);
  }

}
