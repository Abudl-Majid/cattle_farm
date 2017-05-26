package com.tahir.project.service.impl;


import com.tahir.project.dao.TagDao;
import com.tahir.project.model.Tag;
import com.tahir.project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class TagServiceImpl implements TagService{

  @Autowired
  TagDao dao;

  @Override
  public Tag save(Tag Tag) {
    return dao.save(Tag);
  }

  @Override
  public Tag update(Tag Tag) {
    return dao.update(Tag);
  }

  @Override
  public void delete(Integer TagId) {
    dao.delete(TagId);
  }

  @Override
  public Tag findByTagId(Integer TagId) {
    return dao.findByTagId(TagId);
  }

  @Override
  public List<Tag> findAll() {
    return dao.findAll();
  }
}
