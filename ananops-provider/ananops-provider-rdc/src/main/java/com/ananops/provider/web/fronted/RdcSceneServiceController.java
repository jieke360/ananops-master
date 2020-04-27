package com.ananops.provider.web.fronted;

import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.RdcScene;
import com.ananops.provider.model.dto.RdcAddSceneDto;
import com.ananops.provider.model.dto.oss.OptUploadFileReqDto;
import com.ananops.provider.model.dto.oss.OptUploadFileRespDto;
import com.ananops.provider.service.RdcSceneService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by rongshuai on 2020/4/27 13:41
 */
@RestController
@RequestMapping(value = "/rdcScene",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - RdcScene",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RdcSceneServiceController extends BaseController {

    @Resource
    RdcSceneService rdcSceneService;

    @PostMapping(value = "/save")
    @ApiOperation(httpMethod = "POST",value = "编辑场景记录")
    public Wrapper<RdcScene> saveRdcScene(@ApiParam(name = "saveRdcScene",value = "编辑场景")@RequestBody RdcAddSceneDto rdcAddSceneDto){
        logger.info("rdcAddSceneDto={}",rdcAddSceneDto);
        return WrapMapper.ok(rdcSceneService.saveRdcScene(getLoginAuthDto(),rdcAddSceneDto));
    }

    @PostMapping(consumes = "multipart/form-data", value = "/uploadRdcScenePic")
    @ApiOperation(httpMethod = "POST", value = "巡检任务子项上传文件")
    public List<OptUploadFileRespDto> uploadRdcScenePic(HttpServletRequest request, OptUploadFileReqDto optUploadFileReqDto) {
        logger.info("uploadCompanyPicture - 上传文件. optUploadFileReqDto={}", optUploadFileReqDto);
        String fileType = optUploadFileReqDto.getFileType();
        String bucketName = optUploadFileReqDto.getBucketName();
        Preconditions.checkArgument(StringUtils.isNotEmpty(fileType), "文件类型为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(bucketName), "存储地址为空");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        return rdcSceneService.uploadRdcScenePic(multipartRequest, optUploadFileReqDto, getLoginAuthDto());
    }
}
