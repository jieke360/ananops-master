package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.ProductDto;
import com.ananops.provider.model.vo.ProductDetailVo;
import com.ananops.provider.service.MdcProductQueryFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Mdc product query feign hystrix.
 *
 * @author ananops.net@gmail.com
 */
@Component
public class MdcProductQueryFeignHystrix implements MdcProductQueryFeignApi {

	@Override
	public Wrapper<ProductDetailVo> getProductDetail(final Long productId) {
		return null;
	}

	@Override
	public Wrapper<ProductDto> selectById(final Long productId) {
		return null;
	}
}
