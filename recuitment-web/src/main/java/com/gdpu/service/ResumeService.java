package com.gdpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdpu.model.Resume;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author linjia
 * @since 2021-06-04
 */
public interface ResumeService extends IService<Resume> {
    /**
     * 通过userid找简历
     */
    public Resume selectByUid(Integer id);

}
