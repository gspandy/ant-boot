/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-10-02 15:21 创建
 */
package org.antframework.boot.config.annotation;

import org.antframework.boot.config.listener.ConfigListenerType;
import org.bekit.event.annotation.listener.Listener;

import java.lang.annotation.*;

/**
 * 配置监听器
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Listener(type = ConfigListenerType.class)
public @interface ConfigListener {
}
