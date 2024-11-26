package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;

/**
* @author 15854
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2024-11-25 19:22:51
* @Entity com.sky.entity.Category
*/
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}




