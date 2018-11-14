package com.dao;

import com.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    //新增
    public Long insert(Role Role);

    //更新
    public void update(Role SysRole);

    //通过对象进行查询
    public Role select(Role SysRole);

    //通过id进行查询
    public Role selectById(@Param("id") Long id);

    //查询全部
    public List<Role> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExsitName(@Param("name") String name);

    boolean isExsitNameExcludeId(@Param("id") long id, @Param("name") String name);
}
