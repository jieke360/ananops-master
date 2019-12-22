package com.ananops.provider.service;

import com.ananops.provider.service.hystrix.ImcTaskFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by rongshuai on 2019/12/20 18:14
 */
@FeignClient(value = "ananops-provider-imc", configuration = OAuth2FeignAutoConfiguration.class, fallback = ImcTaskFeignHystrix.class)
public interface ImcTaskFeignApi {

}
