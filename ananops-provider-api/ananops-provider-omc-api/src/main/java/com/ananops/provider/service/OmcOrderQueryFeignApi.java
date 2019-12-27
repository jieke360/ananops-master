package com.ananops.provider.service;

import com.ananops.provider.model.dto.OrderDto;
import com.ananops.provider.service.hystrix.OmcOrderQueryFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Omc order query feign api.
 *
 * @author ananops.net @gmail.com
 */
@FeignClient(value = "ananops-provider-omc", configuration = OAuth2FeignAutoConfiguration.class, fallback = OmcOrderQueryFeignHystrix.class)
public interface OmcOrderQueryFeignApi {
	/**
	 * Query by order no wrapper.
	 *
	 * @param orderNo the order no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/queryByOrderNo/{orderNo}")
	Wrapper<OrderDto> queryByOrderNo(@PathVariable("orderNo") String orderNo);

	/**
	 * Query by user id and order no wrapper.
	 *
	 * @param userId  the user id
	 * @param orderNo the order no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/order/queryByUserIdAndOrderNo/{userId}/{orderNo}")
	Wrapper<OrderDto> queryByUserIdAndOrderNo(@PathVariable("userId") Long userId, @PathVariable("orderNo") String orderNo);
}
