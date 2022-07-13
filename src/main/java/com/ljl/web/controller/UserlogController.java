package com.ljl.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.common.Result;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.Userlog;
import com.ljl.web.pojo.query.LogQuery;
import com.ljl.web.pojo.query.StaffQuery;
import com.ljl.web.service.UserlogService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljl
 * @since 2022-05-25
 */
@CrossOrigin
@RestController
@RequestMapping("/web/userlog")
public class UserlogController {

    @Autowired
    UserlogService userlogService;


    //多条件查询讲师带分页
    @ApiOperation(value = "多条件查询员工带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable Long page,
                                @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit,
                                @RequestBody(required = false) LogQuery logQuery){//通过封装TeacherQuery对象来直接传递查询条件
        //创建分页page对象
        Page<Userlog> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        userlogService.pageQuery(pageParam,logQuery);

        //获取查询到的数据
        List<Userlog> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }


    //逻辑删除
    @ApiOperation(value = "根据id删除员工")
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable String id){
        boolean flag = userlogService.removeById(id);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    //新增讲师
    @ApiModelProperty(value = "新增员工")
    @PostMapping("/save")
    public Result save(@RequestBody Userlog userlog){
        boolean flag = userlogService.saveInfo(userlog);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }




}

