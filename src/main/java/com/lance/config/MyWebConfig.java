package com.lance.config;


import com.lance.component.LoginHandlerInterceptor;
import com.lance.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lance
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    /**
     * 自定义视图转发器
     *
     * @param registry
     */
    @Override
    public void addViewControllers (ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/user/login").setViewName("login");
        registry.addViewController("/qmain.html").setViewName("indexdashboard");
        registry.addViewController("/admin.html").setViewName("dashboard");
        registry.addViewController("login").setViewName("login");
    }

    /**
     * 自定义国际化
     *
     * @return MyLocaleResolver()
     */
    @Bean
    public LocaleResolver localeResolver () {
        return new MyLocaleResolver();
    }

    /**
     * 加载自定义拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(
                new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/admin/login", "/adminlogin", "/asserts/**"
                        , "/webjars/bootstrap/**");
    }

    /**上传地址*/
    @Value("${file.path}")
    private String filePath;
    /**显示相对地址*/
    @Value("${file.relative}")
    private String fileRelativePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileRelativePath).
                addResourceLocations("file:/" + filePath);
    }
}
