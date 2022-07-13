package com.ljl.web.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author RookiezzZ
 * @qq 963314043
 * @date 2022/5/26 16:23
 */
@Data
public class WorkAddQuery {

    @ApiModelProperty(value = "员工名称,模糊查询")
    private String sname;

    @ApiModelProperty(value = "id")
    private String sid;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换



}
