package com.tahir.project.service;

import com.tahir.project.model.Farm;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface FarmService {
  Farm save(Farm Farm);
  Farm update(Farm Farm);
  void delete(Integer FarmId);
  Farm findByFarmId(Integer FarmId);
  public List<Farm> findAll();
}
