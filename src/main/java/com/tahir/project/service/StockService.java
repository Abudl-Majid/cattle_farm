package com.tahir.project.service;

import com.tahir.project.model.Stock;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface StockService {
  Stock save(Stock Stock);
  Stock update(Stock Stock);
  void delete(Integer StockId);
  Stock findByStockId(Integer StockId);
  public List<Stock> findAll();
}
