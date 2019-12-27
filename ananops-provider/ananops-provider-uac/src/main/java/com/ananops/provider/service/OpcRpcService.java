package com.ananops.provider.service;

/**
 * The interface Opc rpc service.
 *
 * @author ananops.net @gmail.com
 */
public interface OpcRpcService {

	/**
	 * Gets location by id.
	 *
	 * @param addressId the address id
	 *
	 * @return the location by id
	 */
	String getLocationById(String addressId);
}
