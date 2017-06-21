/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-05-19 20:02 创建
 */
package org.antframework.boot.bekit.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * bekit自动配置类
 */
@Configuration
@Import(BekitConfiguration.class)
public class BekitAutoConfiguration {
    // 自动导入相关配置类
}
