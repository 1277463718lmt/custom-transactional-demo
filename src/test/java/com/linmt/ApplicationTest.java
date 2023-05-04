package com.linmt;

import com.linmt.po.UserPo;
import com.linmt.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: Linmt
 * Date: 2023/5/4
 * Time: 13:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        UserPo user = new UserPo();
        user.setName("张三");
        userService.insertOne(user);
    }
}
