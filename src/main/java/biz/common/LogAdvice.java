package biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect = pointcut + advice
// @Aspect를 사용하려면 반드시 pointcut과 acvice가 결합되어있어야 됨
public class LogAdvice {

    @Pointcut("execution(* biz..*Impl.*(..))")
    public void allPointcut() {}

    @Pointcut("execution(* biz..*Impl.get*(..))")
    public void getPointcut() {}

    @Before("allPointcut()")
    public void printLog(JoinPoint point) {
        System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
    }
}
