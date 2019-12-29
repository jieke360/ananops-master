package com.ananops.provider.web.frontend;

import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.SpcCompany;
import com.ananops.provider.service.SpcCompanyService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 加盟服务商对外提供的Restful接口
 *
 * Created by bingyueduan on 2019/12/28.
 */
@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - SpcCompanyController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SpcCompanyController extends BaseController {

    @Resource
    private SpcCompanyService spcCompanyService;

    @PostMapping(value = "/queryAllCompanys")
    @ApiOperation(httpMethod = "POST", value = "获取全部加盟服务商")
    public Wrapper<PageInfo<SpcCompany>> queryAllCompanys(@ApiParam(name = "spcCompany", value = "服务商信息") @RequestBody SpcCompany spcCompany) {
        logger.info("分页查询服务商列表, spcCompany={}", spcCompany);
        PageHelper.startPage(spcCompany.getPageNum(), spcCompany.getPageSize());
        spcCompany.setOrderBy("update_time desc");
        List<SpcCompany> companyVoList = spcCompanyService.queryAllCompanys(spcCompany);
        return WrapMapper.ok(new PageInfo<>(companyVoList));
    }
}
