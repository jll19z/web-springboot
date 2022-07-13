package com.ljl.web.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("web_vacation")
@ApiModel(value="Vacation对象", description="")
public class Vacation implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "vid", type = IdType.AUTO)
    private Integer vid;

    private Integer sid;

    private String sname;

    private String starttime;

    private String endtime;

    private String vflag;

    private String vinfo;

    private String vtype;


}
