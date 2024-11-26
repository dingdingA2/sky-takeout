package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.entity.User;
import com.sky.enums.StatusEnum;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import com.sky.service.DishService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 15854
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2024-11-25 19:22:51
*/
@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    private final CategoryMapper categoryMapper;
    private final DishService dishService;
    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        log.info("新增分类：{}", category);
        category.setStatus(StatusEnum.DISABLE.getCode());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        save(category);
    }


//    @Override
//    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
//        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
//        //下一条sql进行分页，自动加入limit关键字分页
//        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);
//        return new PageResult(page.getTotal(), page.getResult());
//    }

    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        //下一条sql进行分页，自动加入limit关键字分页
        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public void deleteById(Long id) {
        //判断当前分类是否关联了菜品，如果关联了，则抛出业务异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishLambdaQueryWrapper);
        if (count > 0){
            //关联了菜品，则抛出业务异常
            throw new RuntimeException("当前分类下关联了菜品，不能删除");
        }
        categoryMapper.deleteById(id);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        updateById(category);
    }

    @Override
    public void startOrStop(Integer status, Long id) {
        Category category = getById(id);
        if (category != null){
            category.setStatus(status);
            updateById(category);
        }else {
            throw new RuntimeException("分类不存在");
        }
    }

    @Override
    public List<Category> list(Integer type) {
        if (type == null){
            throw new RuntimeException("分类类型为空");
        }
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getStatus, StatusEnum.ENABLE)
                .eq(Category::getType, type)
                .orderByAsc(Category::getSort)
                .orderByAsc(Category::getCreateTime);
        return this.list(queryWrapper);
    }
}




