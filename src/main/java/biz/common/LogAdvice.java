package biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
public class LogAdvice {

    @Pointcut("execution(* biz..*Impl.*(..))")
    public void allPointcut() {}

    @Pointcut("execution(* biz..*Impl.get*(..))")
    public void getPointcut() {}
}
