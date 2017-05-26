package com.tahir.project.service.impl;


import com.tahir.project.dao.FeedUsedDao;
import com.tahir.project.model.FeedUsed;
import com.tahir.project.service.FeedUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class FeedUsedServiceImpl implements FeedUsedService{

  @Autowired
  FeedUsedDao dao;

  @Override
  public FeedUsed save(FeedUsed FeedUsed) {
    return dao.save(FeedUsed);
  }

  @Override
  public FeedUsed update(FeedUsed FeedUsed) {
    return dao.update(FeedUsed);
  }

  @Override
  public void delete(Integer FeedUsedId) {
    dao.delete(FeedUsedId);
  }

  @Override
  public FeedUsed findByFeedUsedId(Integer FeedUsedId) {
    return dao.findByFeedUsedId(FeedUsedId);
  }

  @Override
  public List<FeedUsed> findAll() {
    return dao.findAll();
  }
}
