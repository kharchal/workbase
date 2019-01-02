package ua.com.hav.workbase;

import org.springframework.beans.factory.annotation.Autowired;
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

import javax.servlet.ServletContextEvent;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class MyContextListener implements javax.servlet.ServletContextListener {

    private ApplicationContext context;
    private AccessRightRepo accessRightRepo;
    private AccessRightsHolder rightsHolder;
    private RoleRepo roleRepo;

    public MyContextListener() {
    }

    public MyContextListener(ApplicationContext context, AccessRightRepo accessRightRepo, AccessRightsHolder rightsHolder, RoleRepo roleRepo) {
        this.context = context;
        this.accessRightRepo = accessRightRepo;
        this.rightsHolder = rightsHolder;
        this.roleRepo = roleRepo;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(".... App is starting ....");
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
        loadAccessRights();
    }

    private void loadAccessRights() {
//        List<AccessRight> all = accessRightRepo.findAll();
        List<Role> allRoles = roleRepo.findAll();
        System.out.println();
        System.out.println("allRoles = " + allRoles);
        System.out.println();

        for (Role role : allRoles) {
            String roleName = role.getValue();
            for (AccessRight right : role.getMappings()) {
                rightsHolder.put(right.getMapping(), roleName);
            }
        }
        System.out.println();
        System.out.println("rightsHolder = " + rightsHolder);
        System.out.println();
    }
}
