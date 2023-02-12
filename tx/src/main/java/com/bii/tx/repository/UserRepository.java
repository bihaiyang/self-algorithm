package com.bii.tx.repository;

import com.bii.tx.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/09
 */
public interface UserRepository  extends JpaRepository<UserPO, Long> {
    
 
    UserPO findByUsername(String username);
   
    boolean existsByEmail(String email);
 
    boolean existsByUsername(String username);
    
}
