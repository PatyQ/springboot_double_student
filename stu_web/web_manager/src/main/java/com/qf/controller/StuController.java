package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.impl.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("stu")
public class StuController {
    @Reference
    IStuService stuService;

    @RequestMapping("sellist")
    public String selStu(ModelMap map){
        List<Student> stulist = stuService.selList();
        map.put("stulist",stulist);
        return "stulist";
    }

    @RequestMapping("addStu")
    public String addStu(){
        return "addstu";
    }

    @RequestMapping(value = "delStuById/{id}")
    public String delStuById(@PathVariable Integer id){

        return "redirect:/stu/sellist";
    }
}
