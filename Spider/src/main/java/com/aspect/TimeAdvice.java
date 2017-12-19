package com.aspect;

import com.annotation.Signature;
import com.annotation.Time;
import org.aspectj.lang.annotation.*;

/**
 * Created by Gene on 2017/11/9.
 */
@Aspect
public class TimeAdvice {
    @Pointcut("execution(public  * com.spider..*.*(..))")
    public void pointCut(){
        System.out.println("pointCut()");
    }
    @Pointcut("@annotation(time)")
    public void pointTime(Time time){
        System.out.println("just annotation time");
    }
    @Pointcut("@annotation(signature)")
    public void pointSsl(Signature signature){

    }

    @Before(value = "pointCut()&&@annotation(time)&&pointSsl(a)")
    public void doBefore1(String a,Time time){
        System.out.println("pointCut() and annotation(time)");
    }
    @Before(value = "pointCut()&&pointTime(time)")
    public void doBefore2(Time time){
        System.out.println("pointCut() and pointTime(time)");
    }
}
