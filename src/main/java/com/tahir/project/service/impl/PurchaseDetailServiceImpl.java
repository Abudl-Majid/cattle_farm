package com.tahir.project.service.impl;


import com.tahir.project.dao.PurchaseDetailDao;
import com.tahir.project.model.Purchase;
import com.tahir.project.model.PurchaseDetail;
import com.tahir.project.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService{

  @Autowired
  PurchaseDetailDao dao;

  @Override
  public PurchaseDetail save(PurchaseDetail PurchaseDetail) {
    return dao.save(PurchaseDetail);
  }

  @Override
  public PurchaseDetail update(PurchaseDetail PurchaseDetail) {
    return dao.update(PurchaseDetail);
  }

  @Override
  public void delete(Integer PurchaseDetailId) {
    dao.delete(PurchaseDetailId);
  }

  @Override
  public PurchaseDetail findByPurchaseDetailId(Integer PurchaseDetailId) {
    return dao.findByPurchaseDetailId(PurchaseDetailId);
  }

  @Override
  public List<PurchaseDetail> findAll() {
    return dao.findAll();
  }

}
