package com.ananops.provider.service;

import com.ananops.provider.model.dto.ItemChangeMaintainerDto;
import com.ananops.provider.model.dto.TaskChangeFacilitatorDto;
import com.ananops.provider.service.hystrix.ImcItemFeignHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Created by rongshuai on 2019/12/18 10:56
 */
@FeignClient(value = "ananops-provider-imc", configuration = OAuth2FeignAutoConfiguration.class, fallback = ImcItemFeignHystrix.class)
public interface ImcItemFeignApi {
//    @PostMapping(value = "/api/item/getByProjectId")
//    Wrapper<List<ItemDto>> getByProjectId(@ApiParam(name = "getTaskByProjectId",value = "根据项目ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto);

    @PostMapping(value = "/api/item/modifyMaintainerByItemId")
    Wrapper<ItemChangeMaintainerDto> modifyMaintainerByItemId(@ApiParam(name = "modifyMaintainerByItemId",value = "修改巡检任务子项对应的工程师ID")@RequestBody ItemChangeMaintainerDto itemChangeMaintainerDto);
}
