package com.ananops.provider.web.frontend;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.core.annotation.AnanLogAnnotation;
import com.ananops.provider.model.domain.ImcItemInvoice;
import com.ananops.provider.model.dto.ImcAddInspectionTaskDto;
import com.ananops.provider.model.dto.ImcInvoiceQueryDto;
import com.ananops.provider.service.ImcItemInvoiceService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
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
 * 巡检单控制器
 *
 * @author Bingyue Duan
 *
 * @version 1.0
 *
 * @date 2020/4/21 下午8:19
 */
@RestController
@RequestMapping(value = "/itemInvoice",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ImcItemInvoiceController",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImcItemInvoiceController extends BaseController {

    @Resource
    private ImcItemInvoiceService imcItemInvoiceService;

    @PostMapping(value = "/queryInvoiceList")
    @ApiOperation(httpMethod = "POST",value = "查询巡检单据列表")
    @AnanLogAnnotation
    public Wrapper<List<ImcItemInvoice>> queryInvoiceList(@ApiParam(name = "imcInvoiceQueryDto",value = "巡检单查询参数")@RequestBody ImcInvoiceQueryDto imcInvoiceQueryDto){
        logger.info("查询巡检单据列表,imcInvoiceQueryDto={}", imcInvoiceQueryDto);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        return WrapMapper.ok(imcItemInvoiceService.queryInvoiceList(imcInvoiceQueryDto,loginAuthDto));
    }
}
