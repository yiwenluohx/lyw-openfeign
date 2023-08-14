package com.study.feignconsumer.client;

import com.study.feignbase.param.AssignParam;
import com.study.feignconsumer.config.FeignRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2023/8/14 下午3:49
 * @menu
 */
@FeignClient(name = "cmp-clue", configuration = FeignRequestInterceptor.class)
public interface AssignClient {

    @RequestMapping(value = "/assign/assignOwner", method = RequestMethod.POST)
    String assignOwner(@RequestBody AssignParam param);

}
