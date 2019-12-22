package com.ananops.provider.service;

import com.ananops.provider.service.hystrix.ImcItemFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;


/**
 * Created by rongshuai on 2019/12/18 10:56
 */
@FeignClient(value = "ananops-provider-imc", configuration = OAuth2FeignAutoConfiguration.class, fallback = ImcItemFeignHystrix.class)
public interface ImcItemFeignApi {
//    @PostMapping(value = "/api/item/getByProjectId")
//    Wrapper<List<ItemDto>> getByProjectId(@ApiParam(name = "getTaskByProjectId",value = "根据项目ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto);

}
