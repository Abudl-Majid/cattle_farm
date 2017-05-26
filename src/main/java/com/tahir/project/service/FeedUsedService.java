package com.tahir.project.service;

import com.tahir.project.model.FeedUsed;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface FeedUsedService {
  FeedUsed save(FeedUsed FeedUsed);
  FeedUsed update(FeedUsed FeedUsed);
  void delete(Integer FeedUsedId);
  FeedUsed findByFeedUsedId(Integer FeedUsedId);
  public List<FeedUsed> findAll();
}
