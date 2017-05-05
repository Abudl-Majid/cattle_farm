package com.tahir.project.service.impl;


import com.tahir.project.dao.PurchaseTypeDao;
import com.tahir.project.model.PurchaseType;
import com.tahir.project.service.PurchaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class PurchaseTypeServiceImpl implements PurchaseTypeService{

  @Autowired
  PurchaseTypeDao dao;

  @Override
  public PurchaseType save(PurchaseType PurchaseType) {
    return dao.save(PurchaseType);
  }

  @Override
  public PurchaseType update(PurchaseType PurchaseType) {
    return dao.update(PurchaseType);
  }

  @Override
  public void delete(Integer PurchaseTypeId) {
    dao.delete(PurchaseTypeId);
  }

  @Override
  public PurchaseType findByPurchaseTypeId(Integer PurchaseTypeId) {
    return dao.findByPurchaseTypeId(PurchaseTypeId);
  }

  @Override
  public List<PurchaseType> findAll() {
    return dao.findAll();
  }
}
