package com.ananops.provider.web.rpc;

import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseController;
import com.ananops.provider.mapper.ImcInspectionItemMapper;
import com.ananops.provider.model.domain.ImcInspectionItem;
import com.ananops.provider.model.dto.ItemChangeMaintainerDto;
import com.ananops.provider.service.ImcInspectionItemService;
import com.ananops.provider.service.ImcInspectionTaskService;
import com.ananops.provider.service.ImcItemFeignApi;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


/**
 * Created by rongshuai on 2019/12/18 10:20
 */
@RefreshScope
@RestController
@Api(value = "API - ImcProjectQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImcItemFeiginClient extends BaseController implements ImcItemFeignApi {
    @Resource
    ImcInspectionTaskService imcInspectionTaskService;
    @Resource
    ImcInspectionItemService imcInspectionItemService;
    @Resource
    ImcInspectionItemMapper imcInspectionItemMapper;

    @Override
    @ApiOperation(httpMethod = "POST", value = "修改巡检任务子项对应的工程师")
    public Wrapper<ItemChangeMaintainerDto> modifyMaintainerByItemId(@ApiParam(name = "modifyMaintainerByItemId",value = "修改巡检任务子项对应的工程师ID")@RequestBody ItemChangeMaintainerDto itemChangeMaintainerDto){
        Long itemId = itemChangeMaintainerDto.getItemId();
        Long maintainerId = itemChangeMaintainerDto.getMaintainerId();
        Example example = new Example(ImcInspectionItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        if(imcInspectionItemMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999097);
        }
        ImcInspectionItem imcInspectionItem = imcInspectionItemService.getItemByItemId(itemId);
        imcInspectionItem.setMaintainerId(maintainerId);
        int result = imcInspectionItemService.update(imcInspectionItem);
        if(result == 1){
            return WrapMapper.ok(itemChangeMaintainerDto);
        }
        throw new BusinessException(ErrorCodeEnum.GL9999093);
    }

}
