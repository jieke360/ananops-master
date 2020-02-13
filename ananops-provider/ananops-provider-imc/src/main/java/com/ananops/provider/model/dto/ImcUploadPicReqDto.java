package com.ananops.provider.model.dto;

import com.ananops.provider.model.dto.oss.OptUploadFileReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/2/11 20:54
 */
@Data
@ApiModel(value = "ImcUploadPicReqDto")
public class ImcUploadPicReqDto implements Serializable {
    private static final long serialVersionUID = 4053734430134538570L;

    /**
     * 任务Id
     */
    @ApiModelProperty(value = "taskId")
    private Long taskId;

    /**
     * 任务子项Id
     */
    @ApiModelProperty(value = "itemId")
    private Long itemId;

    /**
     * 任务子项状态
     */
    @ApiModelProperty(value = "itemStatus")
    private Integer itemStatus;

    /**
     * 文件上传Dto
     */
    @ApiModelProperty(value = "OptUploadFileReqDto")
    private OptUploadFileReqDto optUploadFileReqDto;



}
