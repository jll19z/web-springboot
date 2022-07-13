package com.ljl.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.web.pojo.query.DepartmentQuery;
import com.ljl.web.pojo.vo.departmentVO.OneSubject;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-05-19
 */
public interface DepartmentService extends IService<Department> {

    List<OneSubject> getAllOneTwo();

    void pageQuery(Page<Department> pageParam, DepartmentQuery departmentQuery);
}
