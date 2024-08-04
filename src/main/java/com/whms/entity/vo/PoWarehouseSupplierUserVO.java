package com.whms.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PoWarehouseSupplierUserVO implements Serializable {
    @ApiModelProperty(value = "入库记录id")
    private Integer poid;
    @ApiModelProperty(value = "操作员id")
    private Integer id;
    @ApiModelProperty(value = "供应商id")
    private Integer sid;
    @ApiModelProperty(value = "入库仓库id")
    private Integer wid;
    @ApiModelProperty(value = "入库操作的时间")
    private LocalDateTime potime;
    @ApiModelProperty(value = "入库订货的总成本")
    private BigDecimal pototalCost;

    private String sname;
    private String saddr;
    private String sphone;
    private String sdesc;

    @ApiModelProperty(value = "姓名")
    private String nickName;
    @ApiModelProperty(value = "仓库名称")
    private String wname;

    @ApiModelProperty(value = "仓库地址")
    private String waddr;



}
