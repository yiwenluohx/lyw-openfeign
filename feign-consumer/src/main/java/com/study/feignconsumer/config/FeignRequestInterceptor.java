package com.study.feignconsumer.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * feign请求拦截器，添加header、token等参数
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2023/8/14 下午4:31
 * @menu feign请求拦截器，添加header、token等参数
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    private final static Logger log = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if(null == getHttpServletRequest() ) {
//            throw new ServiceException("403", "noTokenRequestHeader");
            log.error("noTokenRequestHeader");
            return;
        }
        String userId = getHttpServletRequest().getHeader("userId");
        requestTemplate.header("userId", userId);
        requestTemplate.header("token", getHeaders(getHttpServletRequest()).get("token"));
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            /**
             * 仅限于Feign不开启Hystrix支持时
             * RequestContextHolder.getRequestAttributes()该方法是从ThreadLocal变量里面取得相应信息的
             * ，当hystrix断路器的隔离策略为THREAD时，是无法取得ThreadLocal中的值
             * 解决方案：
             * 方案一：hystrix隔离策略换为SEMAPHORE
             * 方案二：Hystrix不太建议使用SEMAPHORE作为隔离策略。只能自定义并发策略
             *    1）只需编写一个类，让其继承HystrixConcurrencyStrategy ，并重写wrapCallable 方法即可
             */
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Feign拦截器拦截请求获取Token对应的值
     * @param request
     * @return
     */
    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
