package com.ananops.provider.model.service;

import com.ananops.provider.model.dto.user.UserInfoDto;
import com.ananops.provider.model.dto.user.UserRegisterDto;
import com.ananops.provider.model.service.hystrix.UacUserFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 开放内部模块对UAC User的API
 *
 * Created by bingyueduan on 2019/12/29.
 */
@FeignClient(value = "ananops-provider-uac", configuration = OAuth2FeignAutoConfiguration.class, fallback = UacUserFeignHystrix.class)
public interface UacUserFeignApi {

    /**
     * 在UAC中注册用户.
     *
     * @return the wrapper
     */
    @PostMapping(value = "/api/uac/user/register")
    Wrapper<Long> userRegister(@RequestBody UserRegisterDto userRegisterDto);

    /**
     * 根据UserId获取用户信息
     *
     * @param userId
     *
     * @return
     */
    @PostMapping(value = "/api/uac/user/getUacUserById")
    Wrapper<UserInfoDto> getUacUserById(@RequestParam("userId") Long userId);

}
