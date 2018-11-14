package com.service;

import com.entity.Role;
import com.github.pagehelper.PageInfo;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 20:27 2018/11/14
 */
public interface RoleService {

    boolean isExsitRoleName(String name);

    long insertRole(Role sysRole, String permissionIds);

    void updateRole(Role sysRole, String permissionIds);

    boolean isExsitRoleNameExcludeId(long id, String name);

    Role selectById(long id);



    void deleteRole(Role sysRole);
}
