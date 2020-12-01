package org.xp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xp.entity.User;
import org.xp.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xupeng
 * @date 2020/12/1 9:30
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {


    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users =  userMapper.selectList(null);

        users.forEach(i -> System.out.println(i.getName()));
    }

}
