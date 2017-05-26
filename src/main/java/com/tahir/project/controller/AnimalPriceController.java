package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.AnimalPrice;
import com.tahir.project.service.AnimalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animalPrice")
public class AnimalPriceController {

  @Autowired
  AnimalPriceService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<AnimalPrice> listAnimalPrices(ModelMap model) {

    List<AnimalPrice> AnimalPrices = service.findAll();
    model.addAttribute("AnimalPrices", AnimalPrices);
    return AnimalPrices;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody AnimalPrice  saveAnimalPrice(@RequestBody AnimalPrice AnimalPrice) {
    service.save(AnimalPrice);
    return AnimalPrice;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody AnimalPrice  updateAnimalPrice(@RequestBody AnimalPrice AnimalPrice) {
    service.update(AnimalPrice);
    return AnimalPrice;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{AnimalPrice_id}" }, method = RequestMethod.GET)
  public @ResponseBody AnimalPrice  getAnimalPrice(@PathVariable("AnimalPrice_id") Integer AnimalPrice_id) {
    return service.findByAnimalPriceId(AnimalPrice_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{AnimalPrice_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteAnimalPrice(@PathVariable("AnimalPrice_id") Integer AnimalPrice_id) {
    service.delete(AnimalPrice_id);
  }

}
