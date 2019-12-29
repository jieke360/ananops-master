package com.ananops.config;


import com.ananops.config.properties.AnanopsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The class Aliyun core config.
 *
 * @author ananops.net @gmail.com
 */
@Configuration
@EnableConfigurationProperties(AnanopsProperties.class)
public class AnanopsCoreConfig {
}
