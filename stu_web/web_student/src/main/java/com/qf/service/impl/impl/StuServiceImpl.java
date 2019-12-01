package com.qf.service.impl.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuDao;
import com.qf.entity.Student;
import com.qf.service.impl.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuDao stuDao;

    @Override
    public List<Student> selList() {
        List<Student> studentList = stuDao.selectList(null);

        return studentList;
    }
}
