package com.ananops.provider.model.service.hystrix;

import com.ananops.provider.model.dto.group.GroupBindUserApiDto;
import com.ananops.provider.model.service.UacGroupBindUserFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UAC模块GroupBindUser Feign Hystrix
 *
 * Created by bingyueduan on 2020/1/15.
 */
@Component
public class UacGroupBindUserFeignHystrix implements UacGroupBindUserFeignApi {

    @Override
    public Wrapper bindUacUser4Group(@RequestBody GroupBindUserApiDto groupBindUserDto) {
        return null;
    }

    @Override
    public Wrapper<Long> getGroupIdByUserId(Long userId) {
        return null;
    }
}
