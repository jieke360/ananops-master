package com.ananops.provider.service;

import com.ananops.provider.model.dto.ItemDto;
import com.ananops.provider.service.hystrix.ImcItemQueryFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by rongshuai on 2019/12/18 10:56
 */
@FeignClient(value = "ananops-provider-imc", configuration = OAuth2FeignAutoConfiguration.class, fallback = ImcItemQueryFeignHystrix.class)
public interface ImcItemQueryFeignApi {
    @PostMapping(value = "/api/item/getByProjectId/{projectId}")
    Wrapper<List<ItemDto>> getByProjectId(@PathVariable("projectId")Long projectId);
}
