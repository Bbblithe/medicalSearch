package com.blithe.medical_search.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 11:17
 * Description:
 */

@Configuration
@ComponentScan({"com.blithe.medical_search.service"})
@PropertySource("classpath:jdbc.properties")
@PropertySource("classpath:segment_phrase_dict_define.txt")
@Import({JdbcConfig.class,MyBatisConfig.class})
public class SpringConfig {
}
