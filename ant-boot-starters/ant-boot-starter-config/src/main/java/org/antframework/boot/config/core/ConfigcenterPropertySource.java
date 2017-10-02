/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-09-25 21:26 创建
 */
package org.antframework.boot.config.core;

import org.antframework.configcenter.client.ConfigProperties;
import org.springframework.core.env.EnumerablePropertySource;

/**
 * 以配置中心作为属性资源
 */
public class ConfigcenterPropertySource extends EnumerablePropertySource<ConfigProperties> {
    /**
     * 属性资源名称
     */
    public static final String PROPERTY_SOURCE_NAME = "configcenter";

    public ConfigcenterPropertySource(String name, ConfigProperties source) {
        super(name, source);
    }

    @Override
    public boolean containsProperty(String name) {
        return source.containKey(name);
    }

    @Override
    public String[] getPropertyNames() {
        return source.getPropertyKeys();
    }

    @Override
    public Object getProperty(String name) {
        return source.getProperty(name);
    }
}
