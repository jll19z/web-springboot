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
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("web_department")
@ApiModel(value="Department对象", description="")
public class Department implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "did", type = IdType.AUTO)
    private Integer did;

    private String dname;

    private String dinfo;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private String deleteflag;

    private Integer parentid;


}
