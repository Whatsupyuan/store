package com.captain.store.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class DefaultView extends WebMvcConfigurationSupport {
    /**
     * 类似于在Spring mvc配置文件中加入
     * <mvc:view-controller path="/" view-name="forward:/index"/>
     * 添加跳转。
     * SpringBoot 2.0 中将 WebMvcConfigurerAdapter 替换为 WebMvcConfigurationSupport
     * https://jingyan.baidu.com/article/8275fc8646a33746a13cf659.html
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:relation/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 设置资源路径
     * 问题原因 : 添加默认访问页面之后 , 无法访问到静态资源
     * 解决方法 : 通过以下方法添加静态资源位置 , 则可以通过 /static/资源文件名 可以进行访问
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
