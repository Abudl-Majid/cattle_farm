package com.tahir.project.dao;

import com.tahir.project.model.Tag;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface TagDao {
  Tag save(Tag Tag);
  Tag update(Tag Tag);
  void delete(Integer TagId);
  Tag findByTagId(Integer TagId);
  public List<Tag> findAll();
}
