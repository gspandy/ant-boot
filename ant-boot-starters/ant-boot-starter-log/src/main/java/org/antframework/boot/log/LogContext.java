/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-10-20 16:07 创建
 */
package org.antframework.boot.log;

import ch.qos.logback.classic.LoggerContext;
import org.springframework.core.env.Environment;

/**
 *
 */
public class LogContext {

    private LoggerContext context;
    private Environment environment;
    private LogbackConfigurator configurator;

    public LogContext(LoggerContext context, Environment environment) {
        this.context = context;
        this.environment = environment;
        this.configurator = new LogbackConfigurator(context);
    }

    public LoggerContext getContext() {
        return context;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public LogbackConfigurator getConfigurator() {
        return configurator;
    }
}
