package aspects;

import org.emsi.ConsoleInput;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* org.emsi.App.start(..))")
    public void startAppPointcut(){}
    @Around("startAppPointcut()")
    public void autourStart(ProceedingJoinPoint joinPoint) throws Throwable {
        Scanner sc = ConsoleInput.scanner();
        System.out.println("Username:");
        String username = sc.next();
        System.out.println("Password:");
        String password = sc.next();
        if (username.equals("root") && password.equals("root")){
            joinPoint.proceed();
        }else  {
            System.out.println("Access Denied ...;");
        }
    }
}
