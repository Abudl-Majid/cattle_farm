package com.tahir.project.service.impl;

import com.tahir.project.dao.PurchaseDao;
import com.tahir.project.dao.PurchaseDetailDao;
import com.tahir.project.model.PurchaseDetail;
import com.tahir.project.service.CreatePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 5/18/2017.
 */
@Transactional
@Service
public class CreatePurchaseServiceImpl implements CreatePurchaseService {
    @Autowired
    PurchaseDetailDao dao;
}
