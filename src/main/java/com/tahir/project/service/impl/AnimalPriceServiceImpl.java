package com.tahir.project.service.impl;


import com.tahir.project.dao.AnimalPriceDao;
import com.tahir.project.model.AnimalPrice;
import com.tahir.project.service.AnimalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class AnimalPriceServiceImpl implements AnimalPriceService{

  @Autowired
  AnimalPriceDao dao;

  @Override
  public AnimalPrice save(AnimalPrice AnimalPrice) {
    return dao.save(AnimalPrice);
  }

  @Override
  public AnimalPrice update(AnimalPrice AnimalPrice) {
    return dao.update(AnimalPrice);
  }

  @Override
  public void delete(Integer AnimalPriceId) {
    dao.delete(AnimalPriceId);
  }

  @Override
  public AnimalPrice findByAnimalPriceId(Integer AnimalPriceId) {
    return dao.findByAnimalPriceId(AnimalPriceId);
  }

  @Override
  public List<AnimalPrice> findAll() {
    return dao.findAll();
  }
}
