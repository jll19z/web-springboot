package com.ljl.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Staff;
import com.ljl.web.mapper.StaffMapper;
import com.ljl.web.pojo.query.StaffQuery;
import com.ljl.web.pojo.vo.loginVo.loginVo;
import com.ljl.web.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-05-18
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Override
    public void pageQuery(Page<Staff> pageParam, StaffQuery staffQuery) {

        //构建条件
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = staffQuery.getName();
        String id = staffQuery.getId();


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

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public String getToken(loginVo loginVo) {
        //构建条件
        QueryWrapper <Staff> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String username = loginVo.getUsername();
        String pwd = loginVo.getPassword();

        wrapper.eq("username",username);
        wrapper.eq("password",pwd);
        Staff user = baseMapper.selectOne(wrapper);

        if(user!=null){

            return user.getSname();

        }

        return null;
    }

    @Override
    public Staff getByName(String sname) {
        QueryWrapper <Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("sname",sname);
        Staff user = baseMapper.selectOne(wrapper);
        return user;
    }


}
