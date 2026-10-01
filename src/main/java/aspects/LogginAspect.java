package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
//@Aspect("perclause(issingleton())")
public class LogginAspect {
    Logger logger = Logger.getLogger(LogginAspect.class.getName());
    public LogginAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }
//    long t1,t2;
    @Pointcut("execution(* metier.MetierBanqueImpl.*(..))")
    private void pc1(){}
//    @Before("pc1()")
//    public void avant(JoinPoint joinPoint){
//        t1=System.currentTimeMillis();
//        logger.info("-----------------------------------------------------------");
//        logger.info("Avant l'exécution de la méthode "+joinPoint. getSignature());
//    }
//    @After("pc1()")
//    public void apres(JoinPoint joinPoint){
//        logger.info("Apres l'exécution de la méthode "+joinPoint. getSignature());
//        t2=System.currentTimeMillis();
//        logger.info("Durée d'exécution de la methode "+(t2-t1)+"ms");
//        logger.info("-----------------------------------------------------------");
//    }
    @Around("pc1()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,JoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("-----------------------------------------------------------");
        logger.info("Avant l'exécution de la méthode " + joinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("Apres l'exécution de la méthode " + joinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger. info("Durée d'exécution de la méthode "+(t2-t1)) ;
        logger.info("-----------------------------------------------------------");
        return result;
    }
}
