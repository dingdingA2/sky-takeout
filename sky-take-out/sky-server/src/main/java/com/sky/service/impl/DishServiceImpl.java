package com.sky.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.entity.Dish;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import org.springframework.stereotype.Service;

/**
* @author 15854
* @description 针对表【dish(菜品)】的数据库操作Service实现
* @createDate 2024-11-25 17:56:46
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

}




