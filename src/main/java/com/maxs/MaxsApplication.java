package com.maxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MaxsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaxsApplication.class, args);
    }

}
