package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.ItemChangeMaintainerDto;
import com.ananops.provider.service.ImcItemFeignApi;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Created by rongshuai on 2019/12/18 10:57
 */
@Component
public class ImcItemFeignHystrix implements ImcItemFeignApi {

//    @Override
//    public Wrapper<List<ItemDto>> getByProjectId(Long projectId){
//        return null;
//    }
    @Override
    public Wrapper<ItemChangeMaintainerDto> modifyMaintainerByItemId(@ApiParam(name = "modifyMaintainerByItemId",value = "修改巡检任务子项对应的工程师ID")@RequestBody ItemChangeMaintainerDto itemChangeMaintainerDto){
        return null;
    }

}
