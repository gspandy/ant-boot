/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-10-02 16:01 创建
 */
package org.antframework.boot.config.listener.annotation;

import org.antframework.configcenter.client.core.ChangedProperty;
import org.bekit.event.extension.ListenResolver;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 监听配置被修改解决器
 */
public class ListenConfigChangedResolver implements ListenResolver {
    // 事件类型
    private ConfigChangedEventType eventType;

    @Override
    public void init(Method listenMethod) {
        ConfigListener configListenerAnnotation = AnnotatedElementUtils.findMergedAnnotation(listenMethod.getDeclaringClass(), ConfigListener.class);
        if (configListenerAnnotation == null) {
            throw new IllegalArgumentException("@ListenConfigModified只能标注在配置监听器（@ConfigListener）的方法上");
        }
        // 校验入参
        Class[] parameterTypes = listenMethod.getParameterTypes();
        if (parameterTypes.length != 1) {
            throw new RuntimeException("监听配置被修改方法" + ClassUtils.getQualifiedMethodName(listenMethod) + "的入参必须是（List<ModifiedProperty>）");
        }
        if (parameterTypes[0] != List.class) {
            throw new RuntimeException("监听配置被修改方法" + ClassUtils.getQualifiedMethodName(listenMethod) + "的入参必须是（List<ModifiedProperty>）");
        }
        ResolvableType resolvableType = ResolvableType.forMethodParameter(listenMethod, 0);
        if (resolvableType.getGeneric(0).resolve(Object.class) != ChangedProperty.class) {
            throw new RuntimeException("监听配置被修改方法" + ClassUtils.getQualifiedMethodName(listenMethod) + "的入参必须是（List<ModifiedProperty>）");
        }
        // 设置事件类型
        ListenConfigChanged listenConfigChangedAnnotation = AnnotatedElementUtils.findMergedAnnotation(listenMethod, ListenConfigChanged.class);
        eventType = new ConfigChangedEventType(configListenerAnnotation.configContextName(), listenConfigChangedAnnotation.prefix());
    }

    @Override
    public Object getEventType() {
        return eventType;
    }

    @Override
    public Object[] resolveArgs(Object event) {
        ConfigChangedEvent configModifiedEvent = (ConfigChangedEvent) event;
        return new Object[]{configModifiedEvent.getChangedProperties()};
    }
}
