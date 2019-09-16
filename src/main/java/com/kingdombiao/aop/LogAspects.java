package com.kingdombiao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 描述:
 * 日志切面
 *
 * @author biao
 * @create 2019-09-12 17:03
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.kingdombiao.aop.Calculator.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println("方法名:"+joinPoint.getSignature().getName()+" 除法运算开始运行......参数列表为{"+ Arrays.asList(joinPoint.getArgs()) +"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" 除法运算运行结束..............");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("除法运算返回结果{"+result+"}............");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法运算异常{"+exception+"}............");
    }


   /* @Around("pointCut()")
    public Object aroud(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around:执行目标方法之前.......");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("@Around:执行目标方法之后.......结果{"+result+"}");
        return result;
    }*/
}
