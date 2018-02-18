package com.atm.sim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.atm.sim.servlet.ATMServlet;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
private static Class<Application> applicationClass = Application.class;

@Autowired
private ApplicationContext appContext;

/*
@Bean
public ServletRegistrationBean exampleServletBean() {
	  DispatcherServlet dispatcherServlet = new DispatcherServlet();

      AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
      applicationContext.register(Config.class);
      dispatcherServlet.setApplicationContext(applicationContext);

      ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/ATMSimulation/**");
      servletRegistrationBean.setName("dispatcher");
      servletRegistrationBean.setLoadOnStartup(1);
      return servletRegistrationBean;
}
*/

@Configuration
@PropertySource("classpath:application.properties")
public static class PropertiesWithJavaConfig {
 
   @Bean
   public static PropertySourcesPlaceholderConfigurer
     propertySourcesPlaceholderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
   }
}

@Bean
public ServletRegistrationBean exampleServletBean2() {
    ServletRegistrationBean bean = new ServletRegistrationBean( new ATMServlet(appContext), "/ATMSimulation/**");
    //bean.setServlet( new ATMServlet());
    bean.setName("ATMServlet");
    //bean.setUrlMappings(Arrays.asList("/"));
    bean.setLoadOnStartup(2);
    return bean;
}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder  application) {
        return application.sources(applicationClass);
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
