package com.ananops.provider.web.rpc;

import com.ananops.core.support.BaseController;
import com.ananops.provider.service.ImcInspectionItemService;
import com.ananops.provider.service.ImcInspectionTaskService;
import com.ananops.provider.service.ImcItemFeignApi;
import io.swagger.annotations.Api;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

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
//    @Override
////    @ApiOperation(httpMethod = "POST", value = "根据项目Id查询项目下的所有巡检任务子项")
////    public Wrapper<List<ItemDto>> getByProjectId(@ApiParam(name = "getTaskByProjectId",value = "根据项目ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
////        logger.info("根据项目Id查询其对应的所有巡检任务子项");
////        List<ItemDto> itemDtoList = new ArrayList<>();
////        //先根据项目Id查询所有的巡检任务
////        List<ImcInspectionTask> imcInspectionTaskList = imcInspectionTaskService.getTaskByProjectId(taskQueryDto);
////        imcInspectionTaskList.forEach(task->{
////            String taskName = task.getTaskName();
////            Long taskId = task.getId();
////            List<ImcInspectionItem> items = imcInspectionItemService.getAllItemByTaskId(taskId);
////            items.forEach(item->{
////                ItemDto itemDto = new ItemDto();
////                BeanUtils.copyProperties(item,itemDto);
////                itemDto.setTaskName(taskName);
////                itemDtoList.add(itemDto);
////            });
////        });
////        return WrapMapper.ok(itemDtoList);
////    }

}
