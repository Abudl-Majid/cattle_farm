package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Purchase;
import com.tahir.project.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

  @Autowired
  PurchaseService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Purchase> listPurchases(ModelMap model) {

    List<Purchase> Purchases = service.findAll();
    model.addAttribute("Purchases", Purchases);
    return Purchases;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Purchase  savePurchase(@RequestBody Purchase Purchase) {
    service.save(Purchase);
    return Purchase;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Purchase  updatePurchase(@RequestBody Purchase Purchase) {
    service.update(Purchase);
    return Purchase;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Purchase_id}" }, method = RequestMethod.GET)
  public @ResponseBody Purchase  getPurchase(@PathVariable("Purchase_id") Integer Purchase_id) {
    return service.findByPurchaseId(Purchase_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Purchase_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deletePurchase(@PathVariable("Purchase_id") Integer Purchase_id) {
    service.delete(Purchase_id);
  }

}
