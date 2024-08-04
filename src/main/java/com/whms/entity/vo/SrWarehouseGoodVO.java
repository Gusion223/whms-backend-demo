package com.whms.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SrWarehouseGoodVO implements Serializable {
    private Integer wid;
    private Integer gid;
    private Integer sramount;
    private String wname;
    private String gname;
    private String gunit;
    private String gtype;
    private BigDecimal gunitPrice;
}
