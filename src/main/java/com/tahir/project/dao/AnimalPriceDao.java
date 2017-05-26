package com.tahir.project.dao;

import com.tahir.project.model.AnimalPrice;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface AnimalPriceDao {
  AnimalPrice save(AnimalPrice AnimalPrice);
  AnimalPrice update(AnimalPrice AnimalPrice);
  void delete(Integer AnimalPriceId);
  AnimalPrice findByAnimalPriceId(Integer AnimalPriceId);
  public List<AnimalPrice> findAll();
}
