package com.ananops.security.core.social.support;

import lombok.Data;

/**
 * The class Social user info.
 *
 * @author ananops.net@gmail.com
 */
@Data
public class SocialUserInfo {

	private String providerId;

	private String providerUserId;

	private String nickname;

	private String headimg;

}
