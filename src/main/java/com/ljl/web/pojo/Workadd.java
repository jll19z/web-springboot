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
 * @since 2022-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("web_workadd")
@ApiModel(value="Workadd对象", description="")
public class Workadd implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "wid", type = IdType.AUTO)
    private Integer wid;

    private Integer sid;

    private String sname;

    private String starttime;

    private String endtime;

    private String addmoney;

    private String deleteflag;

    private String workdate;


}
