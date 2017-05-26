package com.tahir.project.service;

import com.tahir.project.model.Purchase;
import com.tahir.project.model.PurchaseDetail;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface PurchaseDetailService {
  PurchaseDetail save(PurchaseDetail PurchaseDetail);
  PurchaseDetail update(PurchaseDetail PurchaseDetail);
  void delete(Integer PurchaseDetailId);
  PurchaseDetail findByPurchaseDetailId(Integer PurchaseDetailId);
  public List<PurchaseDetail> findAll();




}
