package com.whms.entity.vo;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TdGoodVO implements Serializable {

    @ApiModelProperty(value = "移仓记录id")
    private Integer toid;

    @ApiModelProperty(value = "商品id")
    private Integer gid;

    private String gname;

    @ApiModelProperty(value = "转移货物数量")
    private Integer tdamount;
}
