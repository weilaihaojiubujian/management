package dao;

import com.dao.UserDao;
import com.entity.User;
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
 * @Date: Create in 13:26 2018/11/3
 */

@RunWith(value =SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-db.xml")

public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void insert()

    {

        User u=new User();
        u.setId((long)5);
        u.setLoginName("weilai");
        u.setSex(1);
        u.setBirth("10-21");
        u.setAddress("杭州");
        u.setEmail("1004758012@qq.cpm");
        u.setPhone("13867888450");
        u.setPassword("123456");
        u.setRank((long)0);
        u.setCreateTime(new java.util.Date());
        u.setUpdateTime(new java.util.Date());
        u.setCreateBy((long)0);
        u.setUpdateBy((long)0);
        u.setStatus(1);
        u.setIsFinal(2);
        long i=userDao.insert(u);
        System.out.println(i);




    }

    //更新
    @Test
    public void update()
    {
        User u=new User();
        u.setId((long)5);
        u.setPassword("4563");
        userDao.update(u);

    }

    //通过对象进行查询
    @Test
    public void select()
    {
        User u=new User();

        u.setId((long)6);

        User l=userDao.select(u);
        System.out.println(l);

    }

    //通过id进行查询
    @Test
    public void selectById(){
        Long id= Long.valueOf(5);

        User l=userDao.selectById(id);
        System.out.println(l);

    }

    //查询全部
    @Test
    public void selectAll()
    {
        String sort="id";
        String order="DESC";
        String loginName="weilai";
        String email="1004758012@qq.cpm";
        String phone="13867888450";
        String address="杭州";


        List<User> list=userDao.selectAll(sort,order,loginName,email,phone,address);
        for (User u:list)
        {
            System.out.println("用户:"+u);
        }
    }

    //查询数量
    @Test
    public void selectCounts()
    {
        int t=userDao.selectCounts();
        System.out.println("数量:"+t);
    }

    @Test
    public void selectByLoginName()
    {
        String loginName="weilai";
        boolean b=userDao.selectByLoginName(loginName);
        System.out.println("用户是否存在:"+b);
    }

    @Test
    public void deleteById()
    {
        long id=7;
        userDao.deleteById(id);

    }

    @Test
    public void isExistLoginNameExcludeId()
    {
        long id=6;
        String loginName="weilai";
        boolean b=userDao.isExistLoginNameExcludeId(id,loginName);
        System.out.println("是否存在："+b);
    }

    @Test
    public void selectUserByLoginName()
    {
        String loginName="weili";
        User u=userDao.selectUserByLoginName(loginName);
        System.out.println("用户:"+u);
    }


}
