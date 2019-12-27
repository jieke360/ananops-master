package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.AddressDTO;
import com.ananops.provider.service.MdcAddressQueryFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Mdc product query feign hystrix.
 *
 * @author ananops.net@gmail.com
 */
@Component
public class MdcAddressQueryFeignHystrix implements MdcAddressQueryFeignApi {

	@Override
	public Wrapper<AddressDTO> getById(final Long addressId) {
		return null;
	}
}
