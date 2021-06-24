package com.gdpu.service.impl;

import com.gdpu.model.FirstType;
import com.gdpu.mapper.FirstTypeMapper;
import com.gdpu.service.FirstTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
@Service
public class FirstTypeServiceImpl extends ServiceImpl<FirstTypeMapper, FirstType> implements FirstTypeService {
    @Override
    public List<FirstType> selectAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public FirstType selectById(Integer id) {
        return baseMapper.selectById(id);
    }
}
