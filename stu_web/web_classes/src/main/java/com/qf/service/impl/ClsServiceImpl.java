package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClsDao;
import com.qf.entity.ClassesEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClsServiceImpl implements IClsService {

    @Autowired
    private ClsDao clsDao;

    @Override
    public List<ClassesEntity> selClsList() {
        return clsDao.selectList(null);
    }

}
