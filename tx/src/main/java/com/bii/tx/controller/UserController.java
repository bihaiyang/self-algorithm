package com.bii.tx.controller;

import com.bii.tx.entity.UserPO;
import com.bii.tx.service.UserService;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/09
 */
@RestController
@RequestMapping("${api.prefix}/user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @GetMapping("/hello")
    public ResponseEntity<Boolean> hello(){
        return ResponseEntity.ok(true);
    }
    
    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody UserPO userPO){
        return ResponseEntity.ok(userService.create(userPO));
    }
    
    @GetMapping
    public ResponseEntity<Page<UserPO>> paging(){
        return ResponseEntity.ok(userService.paging());
    }
    
}
