package com.ljl.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.web.pojo.query.StaffQuery;
import com.ljl.web.pojo.vo.loginVo.loginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-05-18
 */
public interface StaffService extends IService<Staff> {

    void pageQuery(Page<Staff> pageParam, StaffQuery staffQuery);


    String getToken(loginVo loginVo);


    Staff getByName(String sname);
}
