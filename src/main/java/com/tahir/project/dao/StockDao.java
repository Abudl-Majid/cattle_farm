package com.tahir.project.dao;

import com.tahir.project.model.Stock;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface StockDao {
  Stock save(Stock Stock);
  Stock update(Stock Stock);
  void delete(Integer StockId);
  Stock findByStockId(Integer StockId);
  public List<Stock> findAll();
}
