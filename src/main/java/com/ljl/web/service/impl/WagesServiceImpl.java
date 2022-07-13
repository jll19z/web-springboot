package com.ljl.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Wages;
import com.ljl.web.mapper.WagesMapper;
import com.ljl.web.pojo.Workadd;
import com.ljl.web.pojo.query.WagesQuery;
import com.ljl.web.pojo.query.WorkAddQuery;
import com.ljl.web.service.WagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-05-26
 */
@Service
public class WagesServiceImpl extends ServiceImpl<WagesMapper, Wages> implements WagesService {

    @Override
    public void pageQuery(Page<Wages> pageParam, WagesQuery wagesQuery) {
        //构建条件
        QueryWrapper<Wages> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String sname = wagesQuery.getSname();
        String sid = wagesQuery.getSid();
        String wtime =wagesQuery.getWtime();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(sname)){
            //构建条件
            wrapper.like("sname",sname);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        if (!StringUtils.isEmpty(wtime)){
            //构建条件
            wrapper.like("wtime",wtime);//参数1：数据库字段名； 参数2：模糊查询的值
        }

        //判断是否传入id
        if (!StringUtils.isEmpty(sid)){
            //构造条件
            wrapper.eq("sid",sid);
        }

        //带上门判断后的条件进行分页查询

        baseMapper.selectPage(pageParam,wrapper);

    }
}
