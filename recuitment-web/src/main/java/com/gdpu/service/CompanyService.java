package com.gdpu.service;

import com.gdpu.model.Company;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
