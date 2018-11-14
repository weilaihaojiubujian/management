package com.service;

import com.entity.User;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 19:59 2018/11/14
 */
public interface UserService {

    long insertUser(User user,  String permissionIds);

    boolean isExistLoginName(String loginName);

    void deleteById(long id);

    User selectById(long id);

    boolean isExistLoginNameExcludeId(long id, String loginName);

    void updateUser(User user, String permissionIds);



    void updateUser(User user);

    User selectByLoginName(String loginName);


}
