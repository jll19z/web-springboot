package com.ljl.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Workadd;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.web.pojo.query.WorkAddQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-05-26
 */
public interface WorkaddService extends IService<Workadd> {

    void pageQuery(Page<Workadd> pageParam, WorkAddQuery workAddQuery);
}
