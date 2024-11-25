package com.sky.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.userSaveDTO;
import com.sky.entity.User;

/**
* @author 15854
* @description 针对表【user(用户信息)】的数据库操作Service
* @createDate 2024-11-25 19:23:21
*/
public interface UserService extends IService<User> {

    /**
     * 微信登录
     * @param userSaveDTO
     */
    void save(userSaveDTO userSaveDTO);
}
