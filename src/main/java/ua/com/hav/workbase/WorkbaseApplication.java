package ua.com.hav.workbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ua.com.hav.workbase.aspect.AccessRightsHolder;
import ua.com.hav.workbase.repo.AccessRightRepo;
import ua.com.hav.workbase.repo.RoleRepo;

import javax.servlet.ServletContextListener;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class WorkbaseApplication {


    @Bean
    @Autowired
    public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean(ApplicationContext context,
                                                                                            AccessRightRepo accessRightRepo,
                                                                                            AccessRightsHolder rightsHolder,
                                                                                            RoleRepo roleRepo) {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new MyContextListener(context, accessRightRepo, rightsHolder, roleRepo));
        return bean;
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkbaseApplication.class, args);


    }

}
