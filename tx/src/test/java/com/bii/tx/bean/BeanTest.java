package com.bii.tx.bean;

import com.bii.tx.service.UserService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {
 
    private Logger LOG = LoggerFactory.getLogger(BeanTest.class);
    
    @Resource
    private UserService userService;
    
    @Test
    public void getBeanName(){
        LOG.info(userService.getBeanName());
    }
}
