package com.ljl.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.web.pojo.Department;
import com.ljl.web.mapper.DepartmentMapper;
import com.ljl.web.pojo.Staff;
import com.ljl.web.pojo.query.DepartmentQuery;
import com.ljl.web.pojo.vo.departmentVO.OneSubject;
import com.ljl.web.pojo.vo.departmentVO.TwoSubject;
import com.ljl.web.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-05-19
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {


    @Override
    public List<OneSubject> getAllOneTwo() {
        //查询所有一级分类   parent_id = 0
        QueryWrapper<Department> wrapperOne = new QueryWrapper();
        wrapperOne.eq("parentid","0");
        List<Department> oneSubjectsList = baseMapper.selectList(wrapperOne);

        //查询所有二级分类  parent_id != 0
        QueryWrapper<Department> wrapperTwo = new QueryWrapper();
        wrapperTwo.ne("parentid","0");
        List<Department> twoSubjectsList = baseMapper.selectList(wrapperTwo);

        //创建list集合，用于封装最终数据
        List<OneSubject> finalSubjectList = new ArrayList<>();

        //封装一级分类
        //查询出来所有的一级分类list集合遍历，得到每个一级分类对象，获取每个一级分类对象值
        //封装到要求的最终list集合中
        for (int i = 0; i < oneSubjectsList.size(); i++) { //遍历oneSubjectList集合
            //得到oneSubjectsList中每个eduSubject对象
            Department oSubject = oneSubjectsList.get(i);

            //把eduSubject里面值获取出来，放到oneSubject对象中去
            OneSubject oneSubject = new OneSubject();

//            oneSubject.setId(eduSubject.getId());
//            oneSubject.setTitle(eduSubject.getTitle());
            //把eduSubject值复制到oneSubject中去【要求两个类的复制注入的属性名一致】
            BeanUtils.copyProperties(oSubject,oneSubject);

            //多个OneSubject放到finalSubjectList里面
            finalSubjectList.add(oneSubject);


            //在一级分类循环遍历查询所有的二级分类
            //创建list集合封装每个一级分类的二级分类
            ArrayList<TwoSubject> finalTwoSubjects = new ArrayList<>();

            //遍历二级list集合
            for (int j = 0; j < twoSubjectsList.size(); j++) {
                //获取每个二级分类
                Department tSubject = twoSubjectsList.get(j);
                //判断二级分类parentid和一级分类id是否一样
                if (tSubject.getParentid().equals(oSubject.getDid())){
                    //把tSubject值复制到TwoSubject，最终放在twoSubjectsList中
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject,twoSubject);
                    finalTwoSubjects.add(twoSubject);
                }
            }

            //把一级下面所有二级分类放到oneSubject里面
            oneSubject.setChildren(finalTwoSubjects);


        }

        //封装二级分类


        return  finalSubjectList;

    }

    @Override
    public void pageQuery(Page<Department> pageParam, DepartmentQuery departmentQuery) {

        //构建条件
        QueryWrapper<Department> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = departmentQuery.getName();
        String id = departmentQuery.getId();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(name)){
            //构建条件
            wrapper.like("dname",name);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入id
        if (!StringUtils.isEmpty(id)){
            //构造条件
            wrapper.eq("did",id);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }



}
