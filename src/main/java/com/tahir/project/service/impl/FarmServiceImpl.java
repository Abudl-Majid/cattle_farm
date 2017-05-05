package com.tahir.project.service.impl;


import com.tahir.project.dao.FarmDao;
import com.tahir.project.model.Farm;
import com.tahir.project.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class FarmServiceImpl implements FarmService{

  @Autowired
  FarmDao dao;

  @Override
  public Farm save(Farm farm) {
    return dao.save(farm);
  }

  @Override
  public Farm update(Farm farm) {
    return dao.update(farm);
  }

  @Override
  public void delete(Integer farmId) {
    dao.delete(farmId);
  }

  @Override
  public Farm findByFarmId(Integer farmId) {
    return dao.findByFarmId(farmId);
  }

  @Override
  public List<Farm> findAll() {
    return dao.findAll();
  }
}
