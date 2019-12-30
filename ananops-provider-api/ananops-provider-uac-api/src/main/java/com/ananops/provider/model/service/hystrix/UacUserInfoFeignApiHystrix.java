package com.ananops.provider.model.service.hystrix;

import com.ananops.provider.model.service.UacUserInfoFeignApi;
import com.ananops.provider.model.user.UserInfoDto;
import com.ananops.wrapper.Wrapper;

public class UacUserInfoFeignApiHystrix implements UacUserInfoFeignApi {
    @Override
    public Wrapper<UserInfoDto> queryUserInfoById(Long id) {
        return null;
    }
}
