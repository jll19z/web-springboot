package com.ljl.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Attendance;
import com.ljl.web.mapper.AttendanceMapper;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.query.KQQuerry;
import com.ljl.web.service.AttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

    @Override
    public void pageQuery(Page<Attendance> pageParam, KQQuerry kqQuerry) {
        //构建条件
        QueryWrapper<Attendance> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String sname = kqQuerry.getSname();
        String sid = kqQuerry.getSid();
        String adate =kqQuerry.getAdate();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(sname)){
            //构建条件
            wrapper.like("sname",sname);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        if (!StringUtils.isEmpty(adate)){
            //构建条件
            wrapper.like("adate",adate);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入id
        if (!StringUtils.isEmpty(sid)){
            //构造条件
            wrapper.eq("sid",sid);
        }

        //带上门判断后的条件进行分页查询
        wrapper.orderByDesc(adate);
        baseMapper.selectPage(pageParam, wrapper);
    }
}
