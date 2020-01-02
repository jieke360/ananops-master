package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.ApproSubmitDto;
import com.ananops.provider.service.ActivitiFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActivitiFeignHystrix implements ActivitiFeignApi {

    @Override
    public Wrapper<String> submit(ApproSubmitDto approSubmitDto) {
      return null;
    }
}
