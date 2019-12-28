package com.ananops.provider.service;

import com.ananops.provider.service.hystrix.OmcOrderDetailFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * The interface Omc order detail feign api.
 *
 * @author ananops.net@gmail.com
 */
@FeignClient(value = "ananops-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderDetailFeignHystrix.class)
public interface OmcOrderDetailFeignApi {
}
