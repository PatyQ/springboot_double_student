package com.qf.service.impl;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {

    List<Student> selList();

    Integer addStudent(Student student);
}
