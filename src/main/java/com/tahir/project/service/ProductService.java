package com.tahir.project.service;

import com.tahir.project.model.Product;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface ProductService {
  Product save(Product Product);
  Product update(Product Product);
  void delete(Integer ProductId);
  Product findByProductId(Integer ProductId);
  public List<Product> findAll();
}
