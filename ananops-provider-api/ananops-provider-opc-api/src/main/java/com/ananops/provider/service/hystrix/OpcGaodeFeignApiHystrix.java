package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.gaode.GaodeLocation;
import com.ananops.provider.service.OpcGaodeFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Opc oss feign api hystrix.
 *
 * @author ananops.net@gmail.com
 */
@Component
public class OpcGaodeFeignApiHystrix implements OpcGaodeFeignApi {

	@Override
	public Wrapper<GaodeLocation> getLocationByIpAddr(final String ipAddr) {
		return null;
	}
}
