package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 程序狗没有春天
 * @version 1.00
 * @createTime 2024/11/25 19:15
 */
@ApiModel(value = "用户保存请求参数")
@Data
public class userSaveDTO {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 微信用户唯一标识
     */
    @ApiModelProperty(value = "微信用户唯一标识")
    @NotBlank(message = "微信用户唯一标识不能为空")
    private String openid;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @NotBlank(message = "性别不能为空")
    private String sex;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    @NotBlank(message = "身份证号不能为空")
    private String idNumber;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @NotBlank(message = "头像不能为空")
    private String avatar;

    /**
     *
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
