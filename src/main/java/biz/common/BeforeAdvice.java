package biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
    public void beforeLog(JoinPoint point) {
        String method = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("[사전처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
    }
}
