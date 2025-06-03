package com.wusd.mybatisplustest.datapermission;

import org.springframework.stereotype.Service;

@Service
public class DataPermissionService {
    public String getOrgCondition(Long orgId, String orgField) {
        String deptCondition = "%s = %s";
        return String.format(deptCondition, orgField, orgId + "");
    }
}
