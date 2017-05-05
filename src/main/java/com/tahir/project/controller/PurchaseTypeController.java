package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.PurchaseType;
import com.tahir.project.service.PurchaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchaseType")
public class PurchaseTypeController {

  @Autowired
  PurchaseTypeService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<PurchaseType> listPurchaseTypes(ModelMap model) {

    List<PurchaseType> PurchaseTypes = service.findAll();
    model.addAttribute("PurchaseTypes", PurchaseTypes);
    return PurchaseTypes;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody PurchaseType  savePurchaseType(@RequestBody PurchaseType PurchaseType) {
    service.save(PurchaseType);
    return PurchaseType;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody PurchaseType  updatePurchaseType(@RequestBody PurchaseType PurchaseType) {
    service.update(PurchaseType);
    return PurchaseType;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{PurchaseType_id}" }, method = RequestMethod.GET)
  public @ResponseBody PurchaseType  getPurchaseType(@PathVariable("PurchaseType_id") Integer PurchaseType_id) {
    return service.findByPurchaseTypeId(PurchaseType_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{PurchaseType_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deletePurchaseType(@PathVariable("PurchaseType_id") Integer PurchaseType_id) {
    service.delete(PurchaseType_id);
  }

}
