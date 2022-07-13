package com.ljl.web.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljl
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("web_staff")
@ApiModel(value="Staff对象", description="")
public class Staff implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String sname;

    private String sex;

    private String email;

    private String phone;

    private String wages;

    private String department;

    private String address;

    @TableField(fill = FieldFill.INSERT)
    private String workdate;

    private String username;

    private String password;

    private String avatar;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除")
    private String deleteflag;


}
