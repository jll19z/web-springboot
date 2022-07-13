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
 * @since 2022-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("web_userlog")
@ApiModel(value="Userlog对象", description="")
public class Userlog implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "ulid", type = IdType.AUTO)
    private Integer ulid;

    private Integer sid;

    private String sname;

    private String username;

    @TableField(fill = FieldFill.INSERT)
    private String time;

    private String utype;

    private String utable;

    private String info;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private String deleteflag;


}
