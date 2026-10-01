package aspects;

public aspect FirstAspect {
    pointcut pc1():  execution(* org.emsi.App.ma(..));
//    before():pc1() {
//        System.out.println("--------------------------------------------");
//        System.out.println("Before main from Aspect with Aspect syntax");
//        System.out.println("--------------------------------------------");
//    }
//    after():pc1() {
//        System.out.println("--------------------------------------------");
//        System.out.println("After main from Aspect with Aspect syntax");
//        System.out.println("--------------------------------------------");
//    }
    void around():pc1() {
        System.out.println("--------------------------------------------");
        System.out.println("Before main from Aspect with Aspect syntax");
        System.out.println("--------------------------------------------");
        //Execution de l'operation pointcut
        proceed();
        System.out.println("--------------------------------------------");
        System.out.println("After main from Aspect with Aspect syntax");
        System.out.println("--------------------------------------------");
    }
}
