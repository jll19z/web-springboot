package com.ljl.web.pojo.vo.departmentVO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RookiezzZ
 * @qq 963314043
 * @date 2022/5/19 16:04
 */
@Data
public class OneSubject {

    private int did;
    private String dname;


    //一个一级分类有多个二级分类
    private List<TwoSubject> children = new ArrayList<>();
}
