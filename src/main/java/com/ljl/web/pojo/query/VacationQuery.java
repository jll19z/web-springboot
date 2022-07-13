package com.ljl.web.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author RookiezzZ
 * @qq 963314043
 * @date 2022/5/25 14:32
 */
@Data
public class VacationQuery {
    @ApiModelProperty(value = "员工名称,模糊查询")
    private String sname;

    @ApiModelProperty(value = "id")
    private String sid;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换


    @ApiModelProperty(value = "type")
    private String vtype;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

}
