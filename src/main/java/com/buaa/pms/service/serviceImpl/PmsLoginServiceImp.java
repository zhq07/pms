package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsOrganization;
import com.buaa.pms.mapper.PmsLoginMapper;
import com.buaa.pms.service.PmsLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class PmsLoginServiceImp implements PmsLoginService {

    @Resource
    PmsLoginMapper pmsLoginMapper;

    @Override
    public String pmsLogin(Map<String, String> pmsUser) {
        if (pmsLoginMapper.selectByNameId(pmsUser) != null)
            return "success";
        else
            return "error";
    }
}
