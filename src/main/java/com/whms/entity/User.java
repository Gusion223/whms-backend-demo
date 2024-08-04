package com.whms.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "姓名")
    private String nickName;

    @ApiModelProperty(value = "密码")
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private String password;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "角色 0为管理员, 1为销售员，2为仓管员")
    private Integer userType;

    @ApiModelProperty(value = "Y为有效，其他均无效")
    @TableField("isValid")
    private String isvalid;

    @TableField(exist = false)
    private String token;
}
