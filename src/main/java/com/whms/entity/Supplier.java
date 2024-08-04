package com.whms.entity;

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
@ApiModel(value="Supplier对象", description="")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String sname;

    private String saddr;

    private String sphone;

    private String sdesc;


}
