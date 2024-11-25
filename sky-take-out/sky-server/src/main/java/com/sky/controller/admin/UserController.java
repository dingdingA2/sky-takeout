package com.sky.controller.admin;

import com.sky.dto.userSaveDTO;
import com.sky.result.Result;
import com.sky.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程序狗没有春天
 * @version 1.00
 * @createTime 2024/11/25 19:11
 */
@Api(tags = "用户管理相关接口")
@RequestMapping("/admin/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/page")
    @ApiModelProperty("新增用户")
    public Result<?> save(@RequestBody userSaveDTO userSaveDTO){
        userService.save(userSaveDTO);
        return Result.success();
    }
}
