package com.ljl.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.web.pojo.query.KQQuerry;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-05-25
 */
public interface AttendanceService extends IService<Attendance> {

    void pageQuery(Page<Attendance> pageParam, KQQuerry kqQuerry);
}
