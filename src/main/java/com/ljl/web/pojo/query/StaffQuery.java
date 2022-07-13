package com.ljl.web.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author RookiezzZ
 * @qq 963314043
 * @date 2022/5/19 11:21
 */
@ApiModel(value = "员工查询对象", description = "员工查询对象封装")
@Data
public class StaffQuery implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "员工名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "id")
    private String id;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

}
