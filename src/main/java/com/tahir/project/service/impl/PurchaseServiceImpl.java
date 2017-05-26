package com.tahir.project.service.impl;


import com.tahir.project.dao.PurchaseDao;
import com.tahir.project.model.Purchase;
import com.tahir.project.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class PurchaseServiceImpl implements PurchaseService{

  @Autowired
  PurchaseDao dao;

  @Override
  public Purchase save(Purchase Purchase) {
    return dao.save(Purchase);
  }

  @Override
  public Purchase update(Purchase Purchase) {
    return dao.update(Purchase);
  }

  @Override
  public void delete(Integer PurchaseId) {
    dao.delete(PurchaseId);
  }

  @Override
  public Purchase findByPurchaseId(Integer PurchaseId) {
    return dao.findByPurchaseId(PurchaseId);
  }

  @Override
  public List<Purchase> findAll() {
    return dao.findAll();
  }
}
