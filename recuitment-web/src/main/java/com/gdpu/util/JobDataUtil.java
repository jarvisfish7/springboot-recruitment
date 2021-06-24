package com.gdpu.util;

import com.gdpu.model.Job;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JobDataUtil {
    public static Job toJob(Map<String, String> data) {
        Job job = new Job();
        //工作的名字
        job.setJobName(data.get("job_name"));
        //发布人的id
        job.setCuserId(Integer.parseInt(data.get("cuser")));
        //公司的id
        job.setJobCompanyId(Integer.parseInt(data.get("job_company_id")));
        //工作的地区
        job.setJobLocation(data.get("region"));
        //工作的一类id
        job.setFirstTypeId(Integer.parseInt(data.get("first_value")));
        //工作的二类id
        job.setSecondTypeId(Integer.parseInt(data.get("second_value")));
        //工作的职位id
        job.setJobPosition(Integer.parseInt(data.get("position_value")));
        //工作的技术要求
        job.setRequireTech(data.get("require_tech"));
        //工作的的薪资
        job.setJobSalary(data.get("job_salary"));
        //工作的学历要求
        job.setJobEducation(data.get("job_education"));
        //工作的联系电话
        job.setJobPhone(data.get("job_phone"));
        //工作的邮箱
        job.setJobEmail(data.get("job_email"));
        return job;
    }
}
