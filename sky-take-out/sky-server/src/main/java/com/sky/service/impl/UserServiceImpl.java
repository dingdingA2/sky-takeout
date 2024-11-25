package com.sky.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.dto.userSaveDTO;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import com.sky.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author 15854
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2024-11-25 19:23:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public void save(userSaveDTO userSaveDTO) {
        User user = new User();
        BeanUtils.copyProperties(userSaveDTO, user);
        save(userSaveDTO);
    }
}




