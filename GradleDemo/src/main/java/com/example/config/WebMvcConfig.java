package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
public class WebMvcConfig  extends WebMvcConfigurerAdapter{

	/**
	 * 定义jsp页面视图解析
	 * @return
	 */
	@Bean(name="pageViewResolver")
	public ViewResolver pageViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/**
	 *添加登陆拦截器 
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 哪些不需要登录就可以访问的url
		String[] excludes={"/user/login","/error/init","/api/user/login"};
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludes);
	}

	/**
	 * 静态资源访问
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/st/**").addResourceLocations("/WEB-INF/static/");
		super.addResourceHandlers(registry);
	}
	
}
