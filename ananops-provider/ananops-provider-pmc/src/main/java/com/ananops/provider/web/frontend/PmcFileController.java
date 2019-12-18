package com.ananops.provider.web.frontend;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.PmcContract;
import com.ananops.provider.service.PmcContractService;
import com.ananops.provider.service.PmcFileService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created By ChengHao On 2019/12/9
 */
@RestController
@RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB -PmcFileController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PmcFileController extends BaseController {
    @Autowired
    PmcFileService pmcFileService;
    @Autowired
    PmcContractService pmcContractService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/upload")
    @ApiOperation(httpMethod = "POST", value = "上传合同文件")
    public Wrapper upload(MultipartFile uploadFile, HttpServletRequest req, @RequestBody PmcContract pmcContract) {
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        logger.info("realPath: "+realPath);
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        //给文件重命名
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            uploadFile.transferTo(new File(folder, newName));  //保存操作
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
            pmcContract.setFilePath(filePath);
            pmcContractService.saveContract(pmcContract,loginAuthDto);
            return WrapMapper.ok(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return WrapMapper.ok("上次文件失败");
    }
}
