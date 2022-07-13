package com.ljl.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.common.Result;
import com.ljl.web.pojo.Attendance;
import com.ljl.web.pojo.Department;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.Userlog;
import com.ljl.web.pojo.query.KQQuerry;
import com.ljl.web.pojo.query.LogQuery;
import com.ljl.web.service.AttendanceService;
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
@RequestMapping("/web/attendance")
public class AttendanceController {


    @Autowired
    private AttendanceService attendanceService;

    //多条件查询讲师带分页
    @ApiOperation(value = "多条件查询员工带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable Long page,
                                @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit,
                                @RequestBody(required = false) KQQuerry kqQuerry){//通过封装TeacherQuery对象来直接传递查询条件
        //创建分页page对象
        Page<Attendance> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        attendanceService.pageQuery(pageParam,kqQuerry);

        //获取查询到的数据
        List<Attendance> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }

    //新增讲师
    @ApiModelProperty(value = "新增员工")
    @PostMapping("/save")
    public Result save(@RequestBody Attendance attendance){
        boolean flag = attendanceService.save(attendance);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    @ApiModelProperty(value = "修改员工")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody Attendance attendance){
        boolean flag = attendanceService.updateById(attendance);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @ApiOperation("根据ID查询部门")
    @GetMapping("getById/{id}")
    public Result getDepartment(@PathVariable String id) {
        Attendance byId = attendanceService.getById(id);
        return Result.ok().data("attendance", byId);
    }


}

