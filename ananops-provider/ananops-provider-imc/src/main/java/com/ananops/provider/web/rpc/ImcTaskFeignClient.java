package com.ananops.provider.web.rpc;

import com.ananops.core.support.BaseController;
import com.ananops.provider.service.ImcInspectionTaskLogService;
import com.ananops.provider.service.ImcInspectionTaskService;
import com.ananops.provider.service.ImcTaskFeignApi;
import io.swagger.annotations.Api;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by rongshuai on 2019/12/20 18:13
 */
@RefreshScope
@RestController
@Api(value = "API - ImcTaskFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImcTaskFeignClient extends BaseController implements ImcTaskFeignApi {
    @Resource
    ImcInspectionTaskService imcInspectionTaskService;

    @Resource
    ImcInspectionTaskLogService imcInspectionTaskLogService;

}
