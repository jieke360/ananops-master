package com.ananops.provider.service;

import com.ananops.provider.model.dto.AddressDTO;

/**
 * The interface Omc order service.
 *
 * @author ananops.net@gmail.com
 */
public interface MdcAddressService {
	/**
	 * Gets address by id.
	 *
	 * @param addressId the address id
	 *
	 * @return the address by id
	 */
	AddressDTO getAddressById(Long addressId);
}
