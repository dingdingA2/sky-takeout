package com.sky.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 程序狗没有春天
 * @version 1.00
 * @createTime 2024/11/26 11:05
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

//    注意顺序 code在前导致括号内的在前在后
    private final Integer code;

    private final String name;

}
