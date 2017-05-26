package com.tahir.project.service.impl;


import com.tahir.project.dao.AnimalDao;
import com.tahir.project.model.Animal;
import com.tahir.project.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class AnimalServiceImpl implements AnimalService{

  @Autowired
  AnimalDao dao;

  @Override
  public Animal save(Animal Animal) {
    return dao.save(Animal);
  }

  @Override
  public Animal update(Animal Animal) {
    return dao.update(Animal);
  }

  @Override
  public void delete(Integer AnimalId) {
    dao.delete(AnimalId);
  }

  @Override
  public Animal findByAnimalId(Integer AnimalId) {
    return dao.findByAnimalId(AnimalId);
  }

  @Override
  public List<Animal> findAll() {
    return dao.findAll();
  }
}
