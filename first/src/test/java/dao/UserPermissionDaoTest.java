package dao;

import com.dao.UserPermissionDao;
import com.entity.UserPermission;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 17:31 2018/11/5
 */

@RunWith(value =SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-db.xml")
public class UserPermissionDaoTest {


    @Resource
    private UserPermissionDao userPermissionDao;

    //新增
    @Test
    public void insert()
    {
        UserPermission u=new UserPermission();
        u.setId((long)3);
        u.setUserId((long)5);
        u.setPermissionId((long)1);
        u.setIsFinal(2);
        u.setRank((long)0);
        u.setCreateTime(new java.util.Date());
        u.setUpdateTime(new java.util.Date());
        u.setCreateBy((long)0);
        u.setUpdateBy((long)0);
        u.setStatus(1);
        Long t=userPermissionDao.insert(u);
        System.out.println(t);
    }


    //更新
    @Test
    public void update()
    {
        UserPermission u=new UserPermission();
        u.setId((long)2);
        u.setUserId((long)7);
        userPermissionDao.update(u);
    }

    //通过对象进行查询
    @Test
    public void select()
    {
        UserPermission u=new UserPermission();
        u.setId((long)2);

        UserPermission t=userPermissionDao.select(u);
        System.out.println("查询的UserPermission："+t);

    }

    //通过id进行查询
    @Test
    public void selectById()
    {
        UserPermission u=new UserPermission();
        u.setId((long)2);

        UserPermission t=userPermissionDao.select(u);
        System.out.println("查询的UserPermission："+t);
    }

    //查询全部
    @Test
    public void selectAll()
    {


        List<UserPermission> list=userPermissionDao.selectAll();
        for (UserPermission u:list)
        {
            System.out.println("查询的UserPermission："+u);
        }
    }

    //查询数量
    @Test
    public void selectCounts()
    {


        int t=userPermissionDao.selectCounts();
        System.out.println("数量是："+t);
    }



    @Test
    public void deleteByUserId()
    {

        userPermissionDao.deleteByUserId((long)7);

    }

    @Test
    public void selectByUserId()
    {
        List<UserPermission> list=userPermissionDao.selectByUserId((long)5);
        for (UserPermission u:list)
        {
            System.out.println("查询的UserPermission："+u);
        }
    }
}
