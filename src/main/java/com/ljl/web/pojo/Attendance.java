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
@TableName("web_attendance")
@ApiModel(value="Attendance对象", description="")
public class Attendance implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    private Integer sid;

    private String sname;

    private String deleteflag;

    private String adate;

    private String latetime;

    private String leaveearly;

    private String absence;

    private String avacation;


}
