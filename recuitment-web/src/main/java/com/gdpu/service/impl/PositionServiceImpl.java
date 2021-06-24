package com.gdpu.service.impl;

import com.gdpu.model.Position;
import com.gdpu.mapper.PositionMapper;
import com.gdpu.service.PositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    @Override
    public List<Position> selectAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public Position selectById(Integer id) {
        return baseMapper.selectById(id);
    }
}
