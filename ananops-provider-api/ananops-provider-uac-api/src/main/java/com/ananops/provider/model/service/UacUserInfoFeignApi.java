package com.ananops.provider.model.service;

import com.ananops.provider.model.service.hystrix.UacUserInfoFeignApiHystrix;
import com.ananops.provider.model.user.UserInfoDto;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ananops-provider-uac", configuration = OAuth2FeignAutoConfiguration.class, fallback = UacUserInfoFeignApiHystrix.class)
public interface UacUserInfoFeignApi {
    @PostMapping(value = "/api/uac/userInfo/queryUserInfoById/{id}")
    Wrapper<UserInfoDto> queryUserInfoById(@RequestParam Long id);
}
