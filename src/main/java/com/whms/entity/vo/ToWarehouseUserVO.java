package com.whms.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ToWarehouseUserVO implements Serializable {
    @ApiModelProperty(value = "转储记录id")
    private Integer toid;

    @ApiModelProperty(value = "操作人员")
    private Integer id;

    private String nickName;

    @ApiModelProperty(value = "先前存储仓库的id")
    private Integer widPrev;

    private String  wnamePrev;

    @ApiModelProperty(value = "后续存储的仓库id")
    private Integer widCur;

    private String wnameCur;

    @ApiModelProperty(value = "转储操作的时间")
    private LocalDateTime totime;
}
