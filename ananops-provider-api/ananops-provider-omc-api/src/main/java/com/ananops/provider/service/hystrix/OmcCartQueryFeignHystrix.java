package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.vo.CartVo;
import com.ananops.provider.service.OmcCartQueryFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Omc cart query feign hystrix.
 *
 * @author ananops.net@gmail.com
 */
@Component
public class OmcCartQueryFeignHystrix implements OmcCartQueryFeignApi {

	@Override
	public Wrapper<CartVo> getCartVo(final Long userId) {
		return null;
	}
}
