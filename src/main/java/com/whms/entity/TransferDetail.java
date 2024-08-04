package com.whms.entity;

import java.io.Serializable;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
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
@ApiModel(value="TransferDetail对象", description="")
public class TransferDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @MppMultiId
    @ApiModelProperty(value = "移仓记录id")
    private Integer toid;

    @MppMultiId
    @ApiModelProperty(value = "商品id")
    private Integer gid;

    @ApiModelProperty(value = "转移货物数量")
    private Integer tdamount;


}
