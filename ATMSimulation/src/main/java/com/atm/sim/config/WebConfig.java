package com.atm.sim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.WebJarsResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = { "com.atm.sim" })
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/resources/**").addResourceLocations("/webjars/","/css/","/js/").resourceChain(true)
	        .addResolver(new WebJarsResourceResolver()).addResolver(new PathResourceResolver());
	        super.addResourceHandlers(registry);
    }
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/index").setViewName("index");
	    }
	 
	 @Bean
     public ReloadableResourceBundleMessageSource messageSource() {
             ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
             messageSource.setBasename("classpath:validation");
             messageSource.setDefaultEncoding("UTF-8");
             //messageSource.setCacheSeconds(10); //reload messages every 10 seconds
             return messageSource;
     }

	 /*
	 @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/jsp/");
	        resolver.setSuffix(".jsp");
	        resolver.setViewClass(JstlView.class);
	        registry.viewResolver(resolver);
	    }
	 */
	 
	 
	  @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	  
	   @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/jsp/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	  
	  
}
