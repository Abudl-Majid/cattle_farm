package com.tahir.project.controller;

/**
 * Created by Tahir on 3/7/15.
 */

import com.tahir.project.model.Company;
import com.tahir.project.service.CompanyService;
import com.tahir.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  CompanyService service;
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  @ResponseBody
  public List<Company> listCompanys(ModelMap model) {

    List<Company> Companys = service.findAll();
    model.addAttribute("Companys", Companys);
    return Companys;
  }

  /*
     * This method will provide the medium to add a new employee.
     */
  @RequestMapping(value = { "/" }, method = RequestMethod.POST)
  public @ResponseBody Company  saveCompany(@RequestBody Company Company) {
    service.save(Company);
    return Company;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/" }, method = RequestMethod.PUT)
  public @ResponseBody Company  updateCompany(@RequestBody Company Company) {
    service.update(Company);
    return Company;
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(produces = "application/json", value = { "/{Company_id}" }, method = RequestMethod.GET)
  public @ResponseBody Company  getCompany(@PathVariable("Company_id") Integer Company_id) {
    return service.findByCompanyId(Company_id);
  }

  /*
  * This method will provide the medium to add a new employee.
  */
  @RequestMapping(value = { "/{Company_id}" }, method = RequestMethod.DELETE)
  public @ResponseBody void  deleteCompany(@PathVariable("Company_id") Integer Company_id) {
    service.delete(Company_id);
  }

}
