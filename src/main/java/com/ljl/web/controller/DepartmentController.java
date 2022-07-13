package com.ljl.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.common.Result;
import com.ljl.web.pojo.Department;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.query.DepartmentQuery;
import com.ljl.web.pojo.query.StaffQuery;
import com.ljl.web.pojo.vo.departmentVO.OneSubject;
import com.ljl.web.service.DepartmentService;
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
 * @since 2022-05-19
 */
@CrossOrigin
@RestController
@RequestMapping("/web/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //课程分类列表（树形）
    @ApiOperation(value = "嵌套数据列表")
    @GetMapping("/getAllSubject")
    public Result getAllSubject(){
        //ist集合泛型是一级分类，一级分类中本身含有二级分类
        List<OneSubject> list = departmentService.getAllOneTwo();
        return Result.ok().data("list",list);
    }


    @ApiOperation("根据ID查询部门")
    @GetMapping("getDepartment/{id}")
    public Result getDepartment(@PathVariable String id) {
        Department byId = departmentService.getById(id);
        return Result.ok().data("department", byId);
    }

    //多条件查询讲师带分页
    @ApiOperation(value = "多条件查询员工带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageTeacherCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable Long page,
                                       @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit,
                                       @RequestBody(required = false) DepartmentQuery departmentQuery){//通过封装TeacherQuery对象来直接传递查询条件
        //创建分页page对象
        Page<Department> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        departmentService.pageQuery(pageParam,departmentQuery);

        //获取查询到的数据
        List<Department> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }


    //逻辑删除
    @ApiOperation(value = "根据id删除部门")
    @DeleteMapping("/deleteById/{id}")
    public Result deleteTeacherById(@PathVariable String id){
        boolean flag = departmentService.removeById(id);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    //新增讲师
    @ApiModelProperty(value = "新增部门")
    @PostMapping("/save")
    public Result save(@RequestBody Department department){
        boolean flag = departmentService.save(department);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    @ApiModelProperty(value = "修改部门")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody Department department){
        boolean flag = departmentService.updateById(department);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

}

