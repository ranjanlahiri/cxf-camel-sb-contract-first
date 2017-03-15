
package example.cxf_camel_sb_contract_first;

//import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


import javax.sql.DataSource;


import org.apache.cxf.transport.servlet.CXFServlet;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;



/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */

@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})


/*
public class Application extends RouteBuilder {

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void configure() throws Exception {
        from("timer://foo?period=5000")
            .setBody().constant("Hello World")
            .log(">>> ${body}");
    }
}

*/

public class Application extends RouteBuilder{

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

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
	}
    
}
