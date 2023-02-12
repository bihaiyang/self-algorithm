package com.bii.tx.entity;


import lombok.*;

import javax.persistence.*;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/09
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserPO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(unique = true)
    private String username;
    
    private String password;
    
    private String email;
    
    @Enumerated(EnumType.STRING)
    private UserRolePO userRole;
    
}
