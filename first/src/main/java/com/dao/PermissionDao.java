package com.dao;

import com.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 12:36 2018/11/3
 */
public interface PermissionDao {

    //新增
    public Long insert(Permission Permission);

    //更新
    public void update(Permission Permission);

    //通过对象进行查询
    public Permission select(Permission Permission);

    //通过id进行查询
    public Permission selectById(@Param("id") Long id);

    //查询全部
    public List<Permission> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExistName(@Param("groupId") long groupId, @Param("name") String name);

    boolean isExistCode(@Param("groupId") long groupId, @Param("code") String code);

    boolean isExistNameExcludeId(@Param("id") long id, @Param("groupId") long groupId, @Param("name") String name);

    boolean isExistCodeExcludeId(@Param("id") long id, @Param("groupId") long groupId, @Param("code") String code);
}
