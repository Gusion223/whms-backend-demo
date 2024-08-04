package com.whms.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SoWarehouseCustomerUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售记录id")
    @TableId(value = "soid", type = IdType.AUTO)
    private Integer soid;

    @ApiModelProperty(value = "顾客id")
    private Integer cid;

    private String cname;

    @ApiModelProperty(value = "仓库id")
    private Integer wid;

    private String wname;

    @ApiModelProperty(value = "业务员id")
    private Integer id;

    private String nickName;

    @ApiModelProperty(value = "销售时间")
    private LocalDateTime sotime;

    @ApiModelProperty(value = "销售总金额")
    private BigDecimal sototal;

}
