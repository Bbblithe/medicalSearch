package com.blithe.medical_search.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 11:45
 * Description:
 */

@Configuration
@ComponentScan({"com.blithe.medical_search.controller","com.blithe.medical_search.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
