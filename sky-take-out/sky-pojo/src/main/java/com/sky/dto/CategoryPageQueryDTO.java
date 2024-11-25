package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "分类分页查询参数")
public class CategoryPageQueryDTO implements Serializable {

    @ApiModelProperty(value = "页码")
    private int page;

    @ApiModelProperty(value = "每页记录数")
    private int pageSize;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "分类类型 1菜品分类  2套餐分类")
    private Integer type;

}
