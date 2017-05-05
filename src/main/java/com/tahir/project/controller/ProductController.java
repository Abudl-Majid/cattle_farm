package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Product;
import com.tahir.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

  @Autowired
  ProductService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Product> listProducts(ModelMap model) {

    List<Product> Products = service.findAll();
    model.addAttribute("Products", Products);
    return Products;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Product  saveProduct(@RequestBody Product Product) {
    service.save(Product);
    return Product;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Product  updateProduct(@RequestBody Product Product) {
    service.update(Product);
    return Product;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Product_id}" }, method = RequestMethod.GET)
  public @ResponseBody Product  getProduct(@PathVariable("Product_id") Integer Product_id) {
    return service.findByProductId(Product_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Product_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteProduct(@PathVariable("Product_id") Integer Product_id) {
    service.delete(Product_id);
  }

}
