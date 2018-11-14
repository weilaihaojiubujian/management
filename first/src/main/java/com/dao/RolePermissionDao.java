package com.dao;

import com.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 12:35 2018/11/3
 */
public interface RolePermissionDao {
    //新增
    public Long insert(RolePermission RolePermission);

    //更新
    public void update(RolePermission RolePermission);

    //通过对象进行查询
    public RolePermission select(RolePermission RolePermission);

    //通过id进行查询
    public RolePermission selectById(@Param("id") Long id);

    //查询全部
    public List<RolePermission> selectAll();

    //查询数量
    public int selectCounts();

    void deleteByRoleId(@Param("roleId") Long roleId);

    List<RolePermission> selectByRoleId(@Param("roleId") Long roleId);
}
