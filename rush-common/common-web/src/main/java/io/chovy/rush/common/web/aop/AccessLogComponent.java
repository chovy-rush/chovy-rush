package io.chovy.rush.common.web.aop;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 记录访问日志
 *
 * @author zhaowei
 */
public class AccessLogComponent {
    private static final Logger log = LoggerFactory.getLogger(AccessLogComponent.class);

    @Pointcut("execution(public * *..controller.*.*(..))")
    public void accessLog() {}

    @Before("accessLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info(
                "[接口请求:{}],[method:{}],[remote:{}:{}],[urlParam:{}]",
                request.getRequestURI(),
                request.getMethod(),
                request.getRemoteAddr(),
                request.getRemotePort(),
                request.getQueryString());
    }

    @AfterReturning(returning = "ret", pointcut = "accessLog()")
    public void doAfterReturning(Object ret) throws Throwable {}
}
