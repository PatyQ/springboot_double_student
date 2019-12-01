package com.qf.service.impl.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuDao;
import com.qf.entity.ClassesEntity;
import com.qf.entity.Student;
import com.qf.service.impl.IClsService;
import com.qf.service.impl.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuDao stuDao;

    @Reference
    private IClsService clsService;

    @Override
    public List<Student> selList() {
        List<Student> studentList = stuDao.selectList(null);
        for (Student s : studentList){
            ClassesEntity classesEntity = clsService.queryById(s.getCid());
            s.setClasses(classesEntity);
        }
        return studentList;
    }

    /**
     * 根据传入的信息添加学生表和班级表
     * @param student
     * @return
     */
    @Override
    public Integer addStudent(Student student) {
        int insert = stuDao.insert(student);
        Integer i = clsService.clsAddStudentNum(student.getCid());
        //判断是否都大于0,成功
        if (insert >0 && i>0){
            return 1;
        }else {
            return -1;
        }
    }
}
