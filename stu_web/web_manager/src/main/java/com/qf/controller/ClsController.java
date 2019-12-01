package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.ClassesEntity;
import com.qf.service.impl.IClsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "cls")
public class ClsController {

    @Reference
    private IClsService clsService;

    @RequestMapping(value = "selclasses")
    public String selclasses(ModelMap map){
        List<ClassesEntity> clsList = clsService.selClsList();
        map.put("cls",clsList);
        return "clslist";
    }
}
