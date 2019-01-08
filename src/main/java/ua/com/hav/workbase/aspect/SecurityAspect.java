package ua.com.hav.workbase.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ua.com.hav.workbase.service.RoleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccessRightsHolder rightsHolder;

//    @Around(value = "execution(* ua.com.hav.workbase.rest.*.* (..))")
//    public Object aroundRest(ProceedingJoinPoint joinPoint) {
//        return doAction(joinPoint, true);
//    }

//    @Around(value = "execution(* ua.com.hav.workbase.web.*.* (..))")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        return doAction(joinPoint, false);
//    }

//    private Object doAction(ProceedingJoinPoint joinPoint, boolean rest) {
//        System.out.println("rightsHolder = " + rightsHolder);
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String methodName = signature.getMethod().getName();
//        String requestLine = "";
//        Method[] methods = joinPoint.getTarget().getClass().getDeclaredMethods();
//        boolean check = false;
//        for(Method m : methods) {
//            if (m.getName().equals(methodName)) {
//                Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
//                for (Annotation a : declaredAnnotations) {
//                    if (m.isAnnotationPresent(RequestMapping.class)) {
//                        RequestMapping annotation = m.getAnnotation(RequestMapping.class);
//                        String[] value = annotation.value();
//                        requestLine = value[0];
//                        check = true;
//                    }
//                }
//                break;
//            }
//        }
//
//        if (!check) {
//            try {
//                return joinPoint.proceed(joinPoint.getArgs());
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        }
//        Object res = null;
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession session = attr.getRequest().getSession(true);// true == allow create
//
//        String userRole = (String) session.getAttribute("userRole");
//        if (userRole == null) {
//            userRole = "nemo";
//            session.setAttribute("userRole", userRole);
//        }
//        check = rightsHolder.check(requestLine, userRole);
////        List<String> rights = (List<String>) session.getAttribute("rights");
////        if (rights == null) {
////            rights = roleService.setRole(session, "nemo");
////        }
//        try {
//
////            if (checkRights(rights, requestLine)) {
//            if (check) {
//                    res = joinPoint.proceed(joinPoint.getArgs());
//            } else {
//                if (!rest) {
//                    attr.getRequest().setAttribute("msg", "ACCESS DENIED!");
//                    res = "index";
//                }
//            }
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return res;
//    }

//    private boolean checkRights(List<String> rights, String requestLine) {
//        if (rights != null && requestLine != null && !requestLine.equals("")) {
//                return rights.contains(requestLine);
//        }
//        return true;
//    }

}
