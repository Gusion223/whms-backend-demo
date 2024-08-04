package com.whms.entity;

import java.io.Serializable;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="StoreRecord对象", description="")
public class StoreRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @MppMultiId
    private Integer wid;

    @MppMultiId
    private Integer gid;

    private Integer sramount;

//    private LocalDateTime sTime;//传参的时候用stime替换


}
