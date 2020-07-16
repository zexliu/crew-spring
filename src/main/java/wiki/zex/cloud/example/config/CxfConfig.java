package wiki.zex.cloud.example.config;
 
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.zex.cloud.example.service.IAttendanceWebService;
import wiki.zex.cloud.example.service.impl.AttendanceWebServiceImpl;

import javax.xml.ws.Endpoint;
 
@Configuration
public class CxfConfig {

    @Bean
    public ServletRegistrationBean<CXFServlet> servletRegistrationBean(){
        return new ServletRegistrationBean<>(new CXFServlet(),"/service/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
 
    @Bean
    public IAttendanceWebService iAttendanceWebService() {
        return new AttendanceWebServiceImpl();
    }
 
    @Bean
    public Endpoint attendanceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), iAttendanceWebService());
        endpoint.publish("/attendance");
        return endpoint;
    }

}