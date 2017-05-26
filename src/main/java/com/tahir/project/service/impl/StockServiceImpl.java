package com.tahir.project.service.impl;


import com.tahir.project.dao.StockDao;
import com.tahir.project.model.Stock;
import com.tahir.project.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class StockServiceImpl implements StockService{

  @Autowired
  StockDao dao;

  @Override
  public Stock save(Stock Stock) {
    return dao.save(Stock);
  }

  @Override
  public Stock update(Stock Stock) {
    return dao.update(Stock);
  }

  @Override
  public void delete(Integer StockId) {
    dao.delete(StockId);
  }

  @Override
  public Stock findByStockId(Integer StockId) {
    return dao.findByStockId(StockId);
  }

  @Override
  public List<Stock> findAll() {
    return dao.findAll();
  }
}
