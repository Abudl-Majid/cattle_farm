package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Farm;
import com.tahir.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/farm")
public class FarmController {

  @Autowired
  FarmService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Farm> listFarms(ModelMap model) {

    List<Farm> Farms = service.findAll();
    model.addAttribute("Farms", Farms);
    return Farms;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Farm  saveFarm(@RequestBody Farm Farm) {
    service.save(Farm);
    return Farm;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Farm  updateFarm(@RequestBody Farm Farm) {
    service.update(Farm);
    return Farm;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Farm_id}" }, method = RequestMethod.GET)
  public @ResponseBody Farm  getFarm(@PathVariable("Farm_id") Integer Farm_id) {
    return service.findByFarmId(Farm_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Farm_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteFarm(@PathVariable("Farm_id") Integer Farm_id) {
    service.delete(Farm_id);
  }

}
