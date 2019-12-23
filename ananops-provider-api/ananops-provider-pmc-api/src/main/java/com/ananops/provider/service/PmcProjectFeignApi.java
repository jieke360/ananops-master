package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.provider.model.dto.PmcProjectDto;
import com.ananops.provider.service.hystrix.PmcProjectFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created By ChengHao On 2019/12/20
 */
@FeignClient(value = "ananops-provider-pmc",configuration = OAuth2FeignAutoConfiguration.class,fallback = PmcProjectFeignHystrix.class)
public interface PmcProjectFeignApi {

    /**
     * 编辑项目信息
     * @param pmcProjectDto
     * @return
     */
    @PostMapping("/api/project/save")
    Wrapper saveProject(@RequestBody PmcProjectDto pmcProjectDto);
}
