package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Stock;
import com.tahir.project.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {

  @Autowired
  StockService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Stock> listStocks(ModelMap model) {

    List<Stock> Stocks = service.findAll();
    model.addAttribute("Stocks", Stocks);
    return Stocks;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Stock  saveStock(@RequestBody Stock Stock) {
    service.save(Stock);
    return Stock;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Stock  updateStock(@RequestBody Stock Stock) {
    service.update(Stock);
    return Stock;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Stock_id}" }, method = RequestMethod.GET)
  public @ResponseBody Stock  getStock(@PathVariable("Stock_id") Integer Stock_id) {
    return service.findByStockId(Stock_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Stock_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteStock(@PathVariable("Stock_id") Integer Stock_id) {
    service.delete(Stock_id);
  }

}
