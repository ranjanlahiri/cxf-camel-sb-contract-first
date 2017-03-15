
package org.jboss.fis2.demo.soap;

import javax.sql.DataSource;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;



/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ServletRegistrationBean servletRegistrationBeanCXF() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(
            new CXFServlet(), "/cxf/*");
        servlet.setName("CXFServlet");
        return servlet;
    }
    
    @Bean(name = "dsFis2")
	@ConfigurationProperties(prefix = "spring.dsFis2")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}
    
}
