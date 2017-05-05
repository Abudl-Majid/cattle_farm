package com.tahir.project.service.impl;


import com.tahir.project.dao.ProductDao;
import com.tahir.project.model.Product;
import com.tahir.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductDao dao;

  @Override
  public Product save(Product Product) {
    return dao.save(Product);
  }

  @Override
  public Product update(Product Product) {
    return dao.update(Product);
  }

  @Override
  public void delete(Integer ProductId) {
    dao.delete(ProductId);
  }

  @Override
  public Product findByProductId(Integer ProductId) {
    return dao.findByProductId(ProductId);
  }

  @Override
  public List<Product> findAll() {
    return dao.findAll();
  }
}
