package com.dao;

import com.entity.PermissionGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 12:38 2018/11/3
 */
public interface PermissionGroupDao {

    //新增
    public Long insert(PermissionGroup PermissionGroup);

    //更新
    public void update(PermissionGroup PermissionGroup);

    //通过对象进行查询
    public PermissionGroup select(PermissionGroup PermissionGroup);

    //通过id进行查询
    public PermissionGroup selectById(@Param("id") Long id);

    //查询全部
    public List<PermissionGroup> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExistGroupName(@Param("name") String name);
}
