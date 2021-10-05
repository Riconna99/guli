package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author LKN
 * @since 2021-10-05
 */
@RestController
@RequestMapping("/eduservice/eduTeacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    //1.查询讲师表所有数据
    //rest风格
    @GetMapping("/finAll")
    public R findAllTeacher(){
        //调用service的方法实现查询所有的操作
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("item",list);
    }
    //2.逻辑删除讲师的方法
    @DeleteMapping("{id}")//id值需要通过路径传id值
    public R removeTeacher(@PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

