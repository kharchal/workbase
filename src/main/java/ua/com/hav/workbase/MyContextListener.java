package ua.com.hav.workbase;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.hav.workbase.annotation.MethodDescription;
import ua.com.hav.workbase.aspect.AccessRightsHolder;
import ua.com.hav.workbase.model.AccessRight;
import ua.com.hav.workbase.model.Role;
import ua.com.hav.workbase.repo.AccessRightRepo;
import ua.com.hav.workbase.repo.RoleRepo;
import ua.com.hav.workbase.service.RoleService;

import javax.servlet.ServletContextEvent;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyContextListener implements javax.servlet.ServletContextListener {

    private ApplicationContext context;
    private AccessRightRepo accessRightRepo;
    private AccessRightsHolder rightsHolder;
    private RoleService roleService;

    public MyContextListener() {
    }

    public MyContextListener(ApplicationContext context, AccessRightRepo accessRightRepo, AccessRightsHolder rightsHolder, RoleService roleService) {
        this.context = context;
        this.accessRightRepo = accessRightRepo;
        this.rightsHolder = rightsHolder;
        this.roleService = roleService;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(".... App is starting ....");
        log.info("App is starting ======================================");
        log.warn("App is starting ======================================");
        log.debug("App is starting ======================================");
        log.error("App is starting ======================================");
        Map<String, Object> allCommandBeans = context.getBeansWithAnnotation(Controller.class);
        System.out.println("allCommandBeans = " + allCommandBeans);
        for (String name : allCommandBeans.keySet()) {
            Class clazz = allCommandBeans.get(name).getClass();
            if (!clazz.isAnnotationPresent(RestController.class)) {
                clazz = clazz.getSuperclass();
            }
            System.out.println("name = " + name);
            System.out.println("clazz = " + clazz);
            boolean contains = clazz.getName().contains("workbase.web");
            if (!contains) {
                contains = clazz.getName().contains("workbase.rest");
            }
            if (contains) {
                Method[] declaredMethods = clazz.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                        String[] mapping = annotation.value();
                        String methodName = method.getName();
                        System.out.println("methodName = " + methodName);
                        String description = "";
                        if (method.isAnnotationPresent(MethodDescription.class)) {
                            description = method.getAnnotation(MethodDescription.class).value();
                            System.out.println("description = " + description);
                        }
                        for (int i = 0; i < mapping.length; i++) {
                            System.out.println("mapping = " + mapping[i]);
                            AccessRight byMapping = accessRightRepo.findByMapping(mapping[i]);
                            if (byMapping == null) {

                                AccessRight right = new AccessRight();
                                right.setMapping(mapping[i]);
                                right.setDescription(description);
                                accessRightRepo.save(right);
                            } else {
                                byMapping.setDescription(description);
                                accessRightRepo.save(byMapping);
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        roleService.loadRights(rightsHolder);
    }

}
