package com.service.impl;

import com.dao.PermissionDao;
import com.dao.UserDao;
import com.dao.UserPermissionDao;
import com.entity.User;
import com.entity.UserPermission;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 20:05 2018/11/14
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPermissionDao userPermissionDao;
    @Autowired
    private PermissionDao permissionDao;



    @Override
    public long insertUser(User user, String permissionIds) {
        userDao.insert(user);

        if (StringUtils.hasText(permissionIds)) {
            String[] permissionIdArray = permissionIds.split(",");
            for (String permissionId : permissionIdArray) {
                UserPermission userPermission = new UserPermission();
                userPermission.setUserId(user.getId());
                userPermission.setPermissionId(Long.valueOf(permissionId));
                userPermission.setIsFinal(1);
                userPermissionDao.insert(userPermission);
            }
        }
        return user.getId();
    }

    @Override
    public boolean isExistLoginName(String loginName) {
        return userDao.selectByLoginName(loginName);
    }

    @Override
    public User selectById(long id) {
        return userDao.selectById(id);
    }

    @Override
    public void updateUser(User user, String permissionIds) {
        userDao.update(user);
        userPermissionDao.deleteByUserId(user.getId());




        if (StringUtils.hasText(permissionIds)) {
            String[] permissionIdArray = permissionIds.split(",");
            for (String permissionId : permissionIdArray) {
                UserPermission userPermission = new UserPermission();
                userPermission.setUserId(user.getId());
                userPermission.setPermissionId(Long.valueOf(permissionId));
                userPermission.setIsFinal(1);
                userPermissionDao.insert(userPermission);
            }
        }

    }



    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public User selectByLoginName(String loginName) {
        return userDao.selectUserByLoginName(loginName);
    }



    @Override
    public boolean isExistLoginNameExcludeId(long id, String loginName) {
        return userDao.isExistLoginNameExcludeId(id, loginName);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
        userPermissionDao.deleteByUserId(id);

    }


}
