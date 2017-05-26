package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.FeedUsed;
import com.tahir.project.service.FeedUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedUsed")
public class FeedUsedController {

  @Autowired
  FeedUsedService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<FeedUsed> listFeedUseds(ModelMap model) {

    List<FeedUsed> FeedUseds = service.findAll();
    model.addAttribute("FeedUseds", FeedUseds);
    return FeedUseds;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody FeedUsed  saveFeedUsed(@RequestBody FeedUsed FeedUsed) {
    service.save(FeedUsed);
    return FeedUsed;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody FeedUsed  updateFeedUsed(@RequestBody FeedUsed FeedUsed) {
    service.update(FeedUsed);
    return FeedUsed;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{FeedUsed_id}" }, method = RequestMethod.GET)
  public @ResponseBody FeedUsed  getFeedUsed(@PathVariable("FeedUsed_id") Integer FeedUsed_id) {
    return service.findByFeedUsedId(FeedUsed_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{FeedUsed_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteFeedUsed(@PathVariable("FeedUsed_id") Integer FeedUsed_id) {
    service.delete(FeedUsed_id);
  }

}
