package com.ljl.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Vacation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.web.pojo.query.VacationQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-05-25
 */
public interface VacationService extends IService<Vacation> {

    void pageQuery(Page<Vacation> pageParam, VacationQuery vacationQuery);
}
