package com.tahir.project.service;

import com.tahir.project.model.Animal;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface AnimalService {
  Animal save(Animal Animal);
  Animal update(Animal Animal);
  void delete(Integer AnimalId);
  Animal findByAnimalId(Integer AnimalId);
  public List<Animal> findAll();
}
