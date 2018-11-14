package com.dao;

import com.entity.UserPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 12:33 2018/11/3
 */
public interface UserPermissionDao {
    //新增
    public Long insert(UserPermission UserPermission);

    //更新
    public void update(UserPermission UserPermission);

    //通过对象进行查询
    public UserPermission select(UserPermission UserPermission);

    //通过id进行查询
    public UserPermission selectById(@Param("id") Long id);

    //查询全部
    public List<UserPermission> selectAll();

    //查询数量
    public int selectCounts();

    void deleteByUserId(@Param("userId") long userId);

    List<UserPermission> selectByUserId(Long userId);
}
