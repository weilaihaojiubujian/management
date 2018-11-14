package com.service.impl;

import com.dao.PermissionDao;
import com.dao.RoleDao;
import com.dao.RolePermissionDao;
import com.entity.Role;
import com.entity.RolePermission;
import com.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 20:33 2018/11/14
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public boolean isExsitRoleName(String name) {
        return roleDao.isExsitName(name);
    }

    @Override
    public long insertRole(Role sysRole, String permissionIds) {
        roleDao.insert(sysRole);
        String[] permissionIdsArray = permissionIds.split(",");
        for (int i = 0; i < permissionIdsArray.length; i++) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(sysRole.getId());
            rolePermission.setPermissionId(Long.valueOf(permissionIdsArray[i]));
            rolePermissionDao.insert(rolePermission);
        }
        return sysRole.getId();
    }

    @Override
    public boolean isExsitRoleNameExcludeId(long id, String name) {
        return roleDao.isExsitNameExcludeId(id, name);
    }

    @Override
    public Role selectById(long id) {
        return roleDao.selectById(id);
    }


    @Override
    public void deleteRole(Role sysRole) {
        roleDao.update(sysRole);
        rolePermissionDao.deleteByRoleId(sysRole.getId());
    }

    @Override
    public void updateRole(Role sysRole, String permissionIds) {
        roleDao.update(sysRole);
        rolePermissionDao.deleteByRoleId(sysRole.getId());
        String[] pIds = permissionIds.split(",");
        for (int i = 0; i < pIds.length; i++) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(sysRole.getId());
            rolePermission.setPermissionId(Long.valueOf(pIds[i]));
            rolePermissionDao.insert(rolePermission);
        }
    }
}
