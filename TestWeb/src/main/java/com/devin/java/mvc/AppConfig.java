package com.devin.java.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by devin on 2016/12/5.
 */
/*To autodetect these classes and register the corresponding beans*/
@Configuration
@ComponentScan(basePackages = "com.devin.java.mvc")
public class AppConfig {
}
