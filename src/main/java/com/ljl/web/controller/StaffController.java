package com.ljl.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.common.Result;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.query.StaffQuery;
import com.ljl.web.service.StaffService;
import io.swagger.annotations.Api;
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
 * @since 2022-05-18
 */
@CrossOrigin
@RestController
@RequestMapping("/web/staff")
@Api("员工管理")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @ApiOperation(value = "所有员工列表")
    @GetMapping("/findall")
    public Result list(){
        List<Staff> list = staffService.list(null);
        return Result.ok().data("items",list);
    }

    //分页查询
    //page：当前页
    //limit：每页显示记录数
    @ApiOperation(value = "分页员工列表")
    @GetMapping("/pageList/{page}/{limit}")
    public Result pageList(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable int page,
                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable int limit
    ){
        Page<Staff> pageParam = new Page<>(page, limit);
        //分页查询，查完后，会将数据封装在pageParam中
        staffService.page(pageParam,null);
        //获取查询到的数据
        List<Staff> records = pageParam.getRecords();
        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);
    }


    @ApiOperation("根据name查询员工")
    @GetMapping("getStaffByname/{sname}")
    public Result getStaffByname(@PathVariable String sname) {
        Staff byName = staffService.getByName(sname);
        return Result.ok().data("staff", byName);
    }


    @ApiOperation("根据ID查询员工")
    @GetMapping("getStaff/{id}")
    public Result getStaff(@PathVariable String id) {
        Staff byId = staffService.getById(id);
        return Result.ok().data("staff", byId);
    }

    //多条件查询讲师带分页
    @ApiOperation(value = "多条件查询员工带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable Long page,
                                  @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit,
                                  @RequestBody(required = false) StaffQuery staffQuery){//通过封装TeacherQuery对象来直接传递查询条件
        //创建分页page对象
        Page<Staff> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        staffService.pageQuery(pageParam,staffQuery);

        //获取查询到的数据
        List<Staff> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }


    //逻辑删除
    @ApiOperation(value = "根据id删除员工")
    @DeleteMapping("/deleteStaffById/{id}")
    public Result deleteById(@PathVariable String id){
        boolean flag = staffService.removeById(id);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    //新增讲师
    @ApiModelProperty(value = "新增员工")
    @PostMapping("/save")
    public Result save(@RequestBody Staff staff){
        boolean flag = staffService.save(staff);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    @ApiModelProperty(value = "修改员工")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody Staff staff){
        boolean flag = staffService.updateById(staff);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

}

