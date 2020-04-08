package chenqian.site.commontest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@Aspect
@Component
public class OperationAspect {



    @Pointcut("@annotation(operationLog)")
    public void operateLog(OperationLog operationLog) {

    }


    @Around(value = "operateLog(operationLog)")
    public Object log(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println(operationLog.name());
        long beginTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        return proceed;
    }
}
