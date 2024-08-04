package com.whms.entity;

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
 * @author whms
 * @since 2024-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Customer对象", description="")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "顾客id")
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    @ApiModelProperty(value = "顾客性别")
    private Integer csex;

    @ApiModelProperty(value = "顾客年龄")
    private Integer cage;

    @ApiModelProperty(value = "顾客名称")
    private String cname;

    @ApiModelProperty(value = "顾客居住地点")
    private String caddr;

    @ApiModelProperty(value = "顾客手机号码")
    private String cphone;


}
