package com.tahir.project.dao;

import com.tahir.project.model.Animal;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface AnimalDao {
  Animal save(Animal Animal);
  Animal update(Animal Animal);
  void delete(Integer AnimalId);
  Animal findByAnimalId(Integer AnimalId);
  public List<Animal> findAll();
}
