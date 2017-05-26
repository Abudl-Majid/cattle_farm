package com.tahir.project.dao;

import com.tahir.project.model.FeedUsed;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface FeedUsedDao {
  FeedUsed save(FeedUsed FeedUsed);
  FeedUsed update(FeedUsed FeedUsed);
  void delete(Integer FeedUsedId);
  FeedUsed findByFeedUsedId(Integer FeedUsedId);
  public List<FeedUsed> findAll();
}
