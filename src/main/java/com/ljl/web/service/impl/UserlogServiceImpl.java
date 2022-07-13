package com.ljl.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.Userlog;
import com.ljl.web.mapper.UserlogMapper;
import com.ljl.web.pojo.query.LogQuery;
import com.ljl.web.service.StaffService;
import com.ljl.web.service.UserlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-05-25
 */
@Service
public class UserlogServiceImpl extends ServiceImpl<UserlogMapper, Userlog> implements UserlogService {

    @Override
    public void pageQuery(Page<Userlog> pageParam, LogQuery logQuery) {
        //构建条件
        QueryWrapper<Userlog> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String sid = logQuery.getSid();
        String sname= logQuery.getSname();
        String username = logQuery.getUsername();
        String time = logQuery.getTime();
        String utable = logQuery.getUtable();
        String utype = logQuery.getUtype();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(sid)){
            //构建条件
            wrapper.eq("sid",sid);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入id
        if (!StringUtils.isEmpty(sname)){
            //构造条件
            wrapper.like("sname",sname);
        }
        if (!StringUtils.isEmpty(username)){
            //构造条件
            wrapper.like("username",username);
        }
        if (!StringUtils.isEmpty(time)){
            //构造条件
            wrapper.like("time",time);
        }
        if (!StringUtils.isEmpty(utable)){
            //构造条件
            wrapper.like("utable",utable);
        }
        if (!StringUtils.isEmpty(utype)){
            //构造条件
            wrapper.like("utype",utype);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }

    @Autowired
    private StaffService staffService;

    @Override
    public boolean saveInfo(Userlog userlog) {


        String sname = userlog.getSname();
        Staff user = staffService.getByName(sname);

        userlog.setUsername(user.getUsername());
        userlog.setSid(user.getSid());

        baseMapper.insert(userlog);

        return true;
    }


}
