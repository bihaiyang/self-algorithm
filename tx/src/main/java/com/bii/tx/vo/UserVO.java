package com.bii.tx.vo;

import com.bii.tx.entity.UserRolePO;
import java.io.Serializable;
import lombok.Data;


/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/09
 */
@Data
public class UserVO implements Serializable {

    private Long id;
    
    private String name;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private UserRolePO userRole;
}
