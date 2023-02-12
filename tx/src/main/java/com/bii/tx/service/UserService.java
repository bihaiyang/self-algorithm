package com.bii.tx.service;

import com.bii.tx.entity.UserPO;
import com.bii.tx.repository.UserRepository;
import javax.annotation.Resource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/09
 */
@Service
public class UserService implements BeanNameAware, BeanFactoryAware {
    
    private String beanName;
    
    private BeanFactory beanFactory;
    
    @Resource
    private UserRepository userRepository;
    
    public boolean create(UserPO userPO){
         userRepository.save(userPO);
         return true;
    }
    
    public Page<UserPO> paging(){
        return userRepository.findAll(Pageable.ofSize(10));
    }
    
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
    
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    
    public String getBeanName(){
        return beanName;
    }
    
    public BeanFactory getBeanFactory(){
        return beanFactory;
    }
   
}
