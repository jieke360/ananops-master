package com.ananops.provider.service.impl;

import com.ananops.PublicUtil;
import com.ananops.base.constant.GlobalConstant;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.RdcSceneMapper;
import com.ananops.provider.model.domain.RdcScene;
import com.ananops.provider.model.dto.RdcAddSceneDto;
import com.ananops.provider.model.dto.attachment.OptAttachmentUpdateReqDto;
import com.ananops.provider.model.dto.attachment.OptUploadFileByteInfoReqDto;
import com.ananops.provider.model.dto.oss.OptUploadFileReqDto;
import com.ananops.provider.model.dto.oss.OptUploadFileRespDto;
import com.ananops.provider.model.service.UacGroupFeignApi;
import com.ananops.provider.service.OpcOssFeignApi;
import com.ananops.provider.service.RdcSceneService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.xiaoleilu.hutool.io.FileTypeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by rongshuai on 2020/4/27 13:37
 */
@Service
public class RdcSceneServiceImpl extends BaseService<RdcScene> implements RdcSceneService {

    @Resource
    RdcSceneMapper rdcSceneMapper;

    @Resource
    UacGroupFeignApi uacGroupFeignApi;

    @Resource
    OpcOssFeignApi opcOssFeignApi;

    @Override
    public RdcScene saveRdcScene(LoginAuthDto loginAuthDto, RdcAddSceneDto rdcAddSceneDto){
        RdcScene rdcScene = new RdcScene();
        BeanUtils.copyProperties(rdcAddSceneDto,rdcScene);
        // 获取登录用户的组织Id
        Long userGroupId = loginAuthDto.getGroupId();
        try{
            // 根据组织Id查询公司Id
            Long groupId = uacGroupFeignApi.getCompanyInfoById(userGroupId).getResult().getId();
            rdcScene.setGroupId(groupId);
        }catch (Exception e){
            throw new BusinessException(ErrorCodeEnum.UAC10015001);
        }
        rdcScene.setUpdateInfo(loginAuthDto);
        if(rdcScene.isNew()){
            Long sceneId = super.generateId();
            rdcScene.setId(sceneId);
            List<String> attachmentIds = rdcAddSceneDto.getAttachmentIds();
            if(attachmentIds != null) {
                Long attachmentId = Long.valueOf(attachmentIds.get(0));
                String refNo = String.valueOf(super.generateId());
                rdcScene.setRefNo(refNo);
                logger.info("rdcScene={}",rdcScene);
                //为附件添加工单号
                OptAttachmentUpdateReqDto optAttachmentUpdateReqDto = new OptAttachmentUpdateReqDto();
                optAttachmentUpdateReqDto.setId(attachmentId);
                optAttachmentUpdateReqDto.setLoginAuthDto(loginAuthDto);
                optAttachmentUpdateReqDto.setRefNo(refNo);
                opcOssFeignApi.updateAttachmentInfo(optAttachmentUpdateReqDto);
            }else{
                throw new BusinessException(ErrorCodeEnum.GL99990100,rdcScene);
            }
            //新建场景
            rdcSceneMapper.insert(rdcScene);
        }else{
            try{
                List<String> attachmentIds = rdcAddSceneDto.getAttachmentIds();
                if(attachmentIds != null) {
                    Long attachmentId = Long.valueOf(attachmentIds.get(0));
                    String refNo = String.valueOf(super.generateId());
                    rdcScene.setRefNo(refNo);
                    //为附件添加工单号
                    OptAttachmentUpdateReqDto optAttachmentUpdateReqDto = new OptAttachmentUpdateReqDto();
                    optAttachmentUpdateReqDto.setId(attachmentId);
                    optAttachmentUpdateReqDto.setLoginAuthDto(loginAuthDto);
                    optAttachmentUpdateReqDto.setRefNo(refNo);
                    opcOssFeignApi.updateAttachmentInfo(optAttachmentUpdateReqDto);
                }else{
                    throw new BusinessException(ErrorCodeEnum.GL99990100,rdcScene);
                }
                //更新参数
                rdcSceneMapper.updateByPrimaryKeySelective(rdcScene);
            }catch (Exception e){
                throw new BusinessException(ErrorCodeEnum.RDC100000005,rdcScene);
            }
        }
        return rdcScene;
    }

    @Override
    public List<OptUploadFileRespDto> uploadRdcScenePic(MultipartHttpServletRequest multipartRequest, OptUploadFileReqDto optUploadFileReqDto, LoginAuthDto loginAuthDto){
        String filePath = optUploadFileReqDto.getFilePath();
        Long userId = loginAuthDto.getUserId();
        String userName = loginAuthDto.getUserName();
        List<OptUploadFileRespDto> result = Lists.newArrayList();
        try {
            List<MultipartFile> fileList = multipartRequest.getFiles("file");
            if (fileList.isEmpty()) {
                return result;
            }

            for (MultipartFile multipartFile : fileList) {
                String fileName = multipartFile.getOriginalFilename();
                if (PublicUtil.isEmpty(fileName)) {
                    continue;
                }
                Preconditions.checkArgument(multipartFile.getSize() <= GlobalConstant.FILE_MAX_SIZE, "上传文件不能大于5M");
                InputStream inputStream = multipartFile.getInputStream();

                String inputStreamFileType = FileTypeUtil.getType(inputStream);
                // 将上传文件的字节流封装到到Dto对象中
                OptUploadFileByteInfoReqDto optUploadFileByteInfoReqDto = new OptUploadFileByteInfoReqDto();
                optUploadFileByteInfoReqDto.setFileByteArray(multipartFile.getBytes());
                optUploadFileByteInfoReqDto.setFileName(fileName);
                optUploadFileByteInfoReqDto.setFileType(inputStreamFileType);
                optUploadFileReqDto.setUploadFileByteInfoReqDto(optUploadFileByteInfoReqDto);
                // 设置不同文件路径来区分图片
                optUploadFileReqDto.setFilePath("ananops/rdc/" + userId + "/" + filePath + "/");
                optUploadFileReqDto.setUserId(userId);
                optUploadFileReqDto.setUserName(userName);
                OptUploadFileRespDto optUploadFileRespDto = opcOssFeignApi.uploadFile(optUploadFileReqDto).getResult();
                result.add(optUploadFileRespDto);
            }
        } catch (IOException e) {
            logger.error("上传文件失败={}", e.getMessage(), e);
        }
        return result;
    }
}
