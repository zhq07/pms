package com.buaa.pms.mapper;

import com.buaa.pms.entity.PmsOrganization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PmsOrganizationMapper {

    List<PmsOrganization> selectAll();

    List<PmsOrganization> selectTop();

    List<PmsOrganization> selectByParUid(String orgParUid);

    PmsOrganization selectByUid(String orgUid);

    void save(PmsOrganization pmsOrganization);

    void deleteByUid(String orgUid);

    void update(PmsOrganization pmsOrganization);

}
