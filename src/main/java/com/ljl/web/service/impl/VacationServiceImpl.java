package com.ljl.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.Vacation;
import com.ljl.web.mapper.VacationMapper;
import com.ljl.web.pojo.query.VacationQuery;
import com.ljl.web.service.VacationService;
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
public class VacationServiceImpl extends ServiceImpl<VacationMapper, Vacation> implements VacationService {

    @Override
    public void pageQuery(Page<Vacation> pageParam, VacationQuery vacationQuery) {
        //构建条件
        QueryWrapper<Vacation> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = vacationQuery.getSname();
        String id = vacationQuery.getSid();
        String vtype = vacationQuery.getVtype();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(name)){
            //构建条件
            wrapper.like("sname",name);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入id
        if (!StringUtils.isEmpty(id)){
            //构造条件
            wrapper.eq("sid",id);
        }

        if (!StringUtils.isEmpty(id)){
            //构造条件
            wrapper.eq("vtype",vtype);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }
}
