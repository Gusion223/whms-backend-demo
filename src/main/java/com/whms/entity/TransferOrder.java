package com.whms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value="TransferOrder对象", description="")
public class TransferOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "转储记录id")
    @TableId(value = "toid", type = IdType.AUTO)
    private Integer toid;

    @ApiModelProperty(value = "操作人员")
    private Integer id;

    @ApiModelProperty(value = "先前存储仓库的id")
    private Integer widPrev;

    @ApiModelProperty(value = "后续存储的仓库id")
    private Integer widCur;

    @ApiModelProperty(value = "转储操作的时间")
    private LocalDateTime totime;


}
