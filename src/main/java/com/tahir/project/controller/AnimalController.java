package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Animal;
import com.tahir.project.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  AnimalService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Animal> listAnimals(ModelMap model) {

    List<Animal> Animals = service.findAll();
    model.addAttribute("Animals", Animals);
    return Animals;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Animal  saveAnimal(@RequestBody Animal Animal) {
    service.save(Animal);
    return Animal;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Animal  updateAnimal(@RequestBody Animal Animal) {
    service.update(Animal);
    return Animal;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Animal_id}" }, method = RequestMethod.GET)
  public @ResponseBody Animal  getAnimal(@PathVariable("Animal_id") Integer Animal_id) {
    return service.findByAnimalId(Animal_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Animal_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteAnimal(@PathVariable("Animal_id") Integer Animal_id) {
    service.delete(Animal_id);
  }

}
