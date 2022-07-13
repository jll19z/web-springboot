package com.ljl.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.Userlog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.web.pojo.query.LogQuery;
import org.apache.catalina.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-05-25
 */
public interface UserlogService extends IService<Userlog> {

    void pageQuery(Page<Userlog> pageParam, LogQuery logQuery);

    boolean saveInfo(Userlog userlog);
}
