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

    /**
     * 通过ID查询班级信息
     * @param id
     * @return
     */
    @Override
    public ClassesEntity queryById(Integer id) {
        ClassesEntity classesEntity = clsDao.selectById(id);
        return classesEntity;
    }

    /**
     * 根据传入课程ID,增加相应的课程人数
     * 先查询出人数,在根据当前人数+1
     * @param cid
     * @return
     */
    @Override
    public Integer clsAddStudentNum(Integer cid) {
        ClassesEntity classesEntity = clsDao.selectById(cid);

        ClassesEntity entity = new ClassesEntity();
        entity.setId(cid);
        if (classesEntity.getCnum()!=null){
            entity.setCnum(classesEntity.getCnum()+1);
        }else {
            entity.setCnum(1);
        }
        int i = clsDao.updateById(entity);
        return i;
    }


}
