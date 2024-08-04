package com.whms.entity.vo;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SdGoodVO implements Serializable {

    @ApiModelProperty(value = "销售记录id")
    private Integer soid;

    @ApiModelProperty(value = "销售商品id")
    private Integer gid;

    private String gname;

    @ApiModelProperty(value = "销售商品数量")
    private Integer sdamount;

    @ApiModelProperty(value = "销售总数")
    private BigDecimal sdtotal;

}
