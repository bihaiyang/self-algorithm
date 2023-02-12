package com.bii.hasor;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bihaiyang
 * @desc
 * @since 2022/12/13
 */
@EnableHasor()
@EnableHasorWeb()
@SpringBootApplication(scanBasePackages = { "com.bii.hasor" })
public class ExampleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
    
}
