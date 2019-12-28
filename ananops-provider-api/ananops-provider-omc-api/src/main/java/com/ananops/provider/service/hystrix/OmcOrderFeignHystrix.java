package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.OrderDto;
import com.ananops.provider.service.OmcOrderFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Omc order feign hystrix.
 *
 * @author ananops.net@gmail.com
 */
@Component
public class OmcOrderFeignHystrix implements OmcOrderFeignApi {

	@Override
	public Wrapper updateOrderById(final OrderDto order) {
		return null;
	}
}
