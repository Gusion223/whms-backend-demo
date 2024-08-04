package com.whms.entity;

import java.math.BigDecimal;
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
@ApiModel(value="Good对象", description="")
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "gid", type = IdType.INPUT)
    private Integer gid;

    @ApiModelProperty(value = "商品名称")
    private String gname;

    @ApiModelProperty(value = "商品类型")
    private String gtype;

    @ApiModelProperty(value = "商品零售价格")
    private BigDecimal gunitPrice;

    @ApiModelProperty(value = "商品单位")
    private String gunit;


}
