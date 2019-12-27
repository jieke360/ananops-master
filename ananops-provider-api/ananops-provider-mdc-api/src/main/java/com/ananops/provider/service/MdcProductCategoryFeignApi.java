package com.ananops.provider.service;

import com.ananops.provider.service.hystrix.MdcProductCategoryFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * The interface Mdc product category feign api.
 *
 * @author ananops.net@gmail.com
 */
@FeignClient(value = "ananops-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductCategoryFeignHystrix.class)
public interface MdcProductCategoryFeignApi {

}
