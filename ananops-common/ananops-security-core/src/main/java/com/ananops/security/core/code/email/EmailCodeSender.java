package com.ananops.security.core.code.email;

/**
 * The interface Sms code sender.
 *
 * @author ananops.net@gmail.com
 */
public interface EmailCodeSender {

	/**
	 * Send.
	 *
	 * @param email the email
	 * @param code  the code
	 */
	void send(String email, String code);

}
