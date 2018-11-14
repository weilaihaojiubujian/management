package dao;

import com.dao.PermissionDao;
import com.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: wanghongbin
 * @Description:
 * @Date: Create in 20:45 2018/11/5
 */
@RunWith(value =SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-db.xml")
public class PermissionDaoTest {

    @Resource
    private PermissionDao permissionDao;

    //新增
    @Test
    public Long insert()
    {
        Permission p=new Permission();

    }
}
