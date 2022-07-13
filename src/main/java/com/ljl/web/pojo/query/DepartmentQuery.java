package com.ljl.web.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author RookiezzZ
 * @qq 963314043
 * @date 2022/5/19 16:54
 */
@ApiModel(value = "部门查询对象", description = "部门查询对象封装")
@Data
public class DepartmentQuery implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "部门名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "id")
    private String id;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

}
