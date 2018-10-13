package biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

    @Before("PointcutCommon.allPointcut()")
    public void beforeLog(JoinPoint point) {
        String method = point.getSignature().getName();
        Object[] args = point.getArgs();
        System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
    }
}
