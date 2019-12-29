package com.ananops.provider.service;


import com.ananops.provider.model.dto.user.LoginRespDto;

/**
 * The interface Uac login service.
 *
 * @author ananops.net@gmail.com
 */
public interface UacLoginService {

	/**
	 * Login after login resp dto.
	 *
	 * @param applicationId the application id
	 *
	 * @return the login resp dto
	 */
	LoginRespDto loginAfter(Long applicationId);

}
