package com.gdpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.model.FirstType;
import com.gdpu.model.SecondType;
import com.gdpu.mapper.SecondTypeMapper;
import com.gdpu.service.SecondTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SecondTypeServiceImpl extends ServiceImpl<SecondTypeMapper, SecondType> implements SecondTypeService {

    @Override
    public List<SecondType> selectAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public SecondType selectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<SecondType> selectByFId(Integer fid) {
        return baseMapper.selectList((new QueryWrapper<SecondType>()).eq("first_id",fid));
    }
}
