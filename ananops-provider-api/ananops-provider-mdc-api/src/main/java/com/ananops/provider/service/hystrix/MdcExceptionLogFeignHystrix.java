package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.GlobalExceptionLogDto;
import com.ananops.provider.service.MdcExceptionLogFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;


/**
 * The class Mdc exception log feign hystrix.
 *
 * @author ananops.net @gmail.com
 */
@Component
public class MdcExceptionLogFeignHystrix implements MdcExceptionLogFeignApi {

	@Override
	public Wrapper saveAndSendExceptionLog(final GlobalExceptionLogDto exceptionLogDto) {
		return null;
	}
}
