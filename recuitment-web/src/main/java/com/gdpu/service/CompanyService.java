package com.gdpu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.model.Company;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
public interface CompanyService extends IService<Company> {
    /**
     * 通过userid查找company
     */
    public Company selectByuid(Integer uid);

    IPage<Company> PageSearch(Page<Company> page, Map<String, String> condition, String keyword);
}
