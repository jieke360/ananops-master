package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.PmcContract;
import com.ananops.provider.model.dto.PmcUploadContractReqDto;
import com.ananops.provider.model.dto.oss.OptUploadFileRespDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/**
 * Created By ChengHao On 2019/12/17
 */
@Service
public interface PmcFileService extends IService<PmcContract> {

    /**
     * 上传合同附件
     *
     * @param multipartRequest
     * @param pmcUploadContractReqDto
     * @param loginAuthDto
     * @return
     */
    List<OptUploadFileRespDto> uploadPmcContract(MultipartHttpServletRequest multipartRequest,
                                                 PmcUploadContractReqDto pmcUploadContractReqDto, LoginAuthDto loginAuthDto);
}
