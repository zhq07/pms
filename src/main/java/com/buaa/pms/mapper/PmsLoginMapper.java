package com.buaa.pms.mapper;

import com.buaa.pms.entity.PmsOrganization;
import com.buaa.pms.entity.PmsUser;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PmsLoginMapper {

    PmsUser selectByNameId(Map<String, String> pmsUser);
}
