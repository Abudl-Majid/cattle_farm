package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Purchase;
import com.tahir.project.model.PurchaseDetail;
import com.tahir.project.service.PurchaseDetailService;
import com.tahir.project.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchaseDetail")
public class PurchaseDetailController {

  @Autowired
  PurchaseDetailService service;

  @Autowired
  PurchaseService purchaseService;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<PurchaseDetail> listPurchaseDetails(ModelMap model) {

    List<PurchaseDetail> PurchaseDetails = service.findAll();
    model.addAttribute("PurchaseDetails", PurchaseDetails);
    return PurchaseDetails;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody PurchaseDetail  savePurchaseDetail(@RequestBody PurchaseDetail PurchaseDetail) {
    service.save(PurchaseDetail);
    return PurchaseDetail;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody PurchaseDetail  updatePurchaseDetail(@RequestBody PurchaseDetail PurchaseDetail) {
    service.update(PurchaseDetail);
    return PurchaseDetail;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{PurchaseDetail_id}" }, method = RequestMethod.GET)
  public @ResponseBody PurchaseDetail  getPurchaseDetail(@PathVariable("PurchaseDetail_id") Integer PurchaseDetail_id) {
    return service.findByPurchaseDetailId(PurchaseDetail_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{PurchaseDetail_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deletePurchaseDetail(@PathVariable("PurchaseDetail_id") Integer PurchaseDetail_id) {
    service.delete(PurchaseDetail_id);
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/detail" }, method = RequestMethod.POST)
  public @ResponseBody PurchaseDetail  savePurchaseAndTheirDetail(@RequestBody PurchaseDetail PurchaseDetail) {
    PurchaseDetail.setPurchase(purchaseService.save(PurchaseDetail.getPurchase()));
    return service.save(PurchaseDetail);
  }
}
