package com.wusd.mybatisplustest.datapermission;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.wusd.mybatisplustest.utils.MapUtils;
import com.wusd.mybatisplustest.utils.ReflectionUtils;
import io.micrometer.common.util.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataPermissionInterceptor implements InnerInterceptor {

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter,
                            RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        Long orgId = Long.valueOf(MapUtils.orgPost.get("orgId"));
        String username = (String) MapUtils.orgPost.get("username");
        if (orgId == null || username == null) return;

        DataPermission dataPermission = getDataPermissionAnnotation(ms);

        String whereClause = buildWhereClause(orgId, username, dataPermission);

        if (StringUtils.isNotEmpty(whereClause)) {
            String originalSql = boundSql.getSql();
            String newSql = originalSql + " AND " + whereClause;
            ReflectionUtils.setFieldValue(boundSql, "sql", newSql);
        }
    }

    private String buildWhereClause(Long orgId, String username, DataPermission dataPermission) {
        if (dataPermission == null) return "";

        List<String> conditions = new ArrayList<>();

        if (orgId != null) {
            String orgCondition = dataPermissionService.getOrgCondition(orgId, dataPermission.orgField());
            conditions.add(orgCondition);
        }

        if (dataPermission.userScope()) {
            String userCondition = dataPermission.userField() + "=" + username;
            conditions.add(userCondition);
        }

        return conditions.isEmpty() ? "" :
                "(" + conditions.stream()
                        .collect(Collectors.joining(" OR ")) + ")";
    }

    @Autowired
    private DataPermissionService dataPermissionService;

    private DataPermission getDataPermissionAnnotation(MappedStatement ms) {
        DataPermission dataPermission = null;
        try {
            String id = ms.getId();
            String methodName = id.substring(id.lastIndexOf(".") + 1);
            String className = id.substring(0, id.lastIndexOf("."));
            Method method = Class.forName(className).getDeclaredMethod(methodName);
            dataPermission = method.getAnnotation(DataPermission.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataPermission;
    }

    public static void main(String[] args) {
        String id = "com.wusd.mybatisplustest.mapper.ProductMapper.queryAll";
        System.out.println(id);
    }
}
