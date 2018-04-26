package dao;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhouyang
 * Date 2018/4/25.
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class IUserVoDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = userDao.selectUser(id);
        System.out.println(user.getUserName());
    }

}
