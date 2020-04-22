package com.ananops.provider.service.impl;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.ImcInspectionItemMapper;
import com.ananops.provider.mapper.ImcItemInvoiceDescMapper;
import com.ananops.provider.mapper.ImcItemInvoiceDeviceMapper;
import com.ananops.provider.mapper.ImcItemInvoiceMapper;
import com.ananops.provider.model.domain.ImcInspectionItem;
import com.ananops.provider.model.domain.ImcItemInvoice;
import com.ananops.provider.model.domain.ImcItemInvoiceDesc;
import com.ananops.provider.model.domain.ImcItemInvoiceDevice;
import com.ananops.provider.model.dto.*;
import com.ananops.provider.service.ImcItemInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bingyue Duan
 * @version 1.0
 * @date 2020/4/21 下午8:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ImcItemInvoiceServiceImpl extends BaseService<ImcItemInvoice> implements ImcItemInvoiceService {

    @Resource
    private ImcItemInvoiceMapper imcItemInvoiceMapper;

    @Resource
    private ImcItemInvoiceDeviceMapper imcItemInvoiceDeviceMapper;

    @Resource
    private ImcItemInvoiceDescMapper imcItemInvoiceDescMapper;

    @Resource
    private ImcInspectionItemMapper imcInspectionItemMapper;

    @Override
    public List<ImcItemInvoice> queryInvoiceList(ImcInvoiceQueryDto imcInvoiceQueryDto, LoginAuthDto loginAuthDto) {
        if (imcInvoiceQueryDto.getItemId() == null) {
            throw new BusinessException(ErrorCodeEnum.IMC10090002);
        }
        if (imcInvoiceQueryDto.getStatus() == null) {
            throw new BusinessException(ErrorCodeEnum.IMC10090009);
        }
        Example example = new Example(ImcItemInvoice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("inspcItemId",imcInvoiceQueryDto.getItemId());
        criteria.andEqualTo("status",imcInvoiceQueryDto.getStatus());
        return imcItemInvoiceMapper.selectByExample(example);
    }

    @Override
    public FormDataDto queryDetailsById(Long invoiceId) {
        FormDataDto formDataDto = new FormDataDto();
        ImcItemInvoice imcItemInvoice = imcItemInvoiceMapper.selectByPrimaryKey(invoiceId);
        if (imcItemInvoice == null) {
            throw new BusinessException(ErrorCodeEnum.IMC10090010, invoiceId);
        }
        BeanUtils.copyProperties(imcItemInvoice,formDataDto);
        InspcFeedBack inspcFeedBack = new InspcFeedBack();
        BeanUtils.copyProperties(imcItemInvoice,inspcFeedBack);
        formDataDto.setFeedback(inspcFeedBack);
        // 回显设备列表项
        Example example = new Example(ImcItemInvoiceDevice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("invoiceId",invoiceId);
        example.setOrderByClause("`sort` ASC");
        List<ImcItemInvoiceDevice> imcItemInvoiceDevices = imcItemInvoiceDeviceMapper.selectByExample(example);
        if (imcItemInvoiceDevices != null) {
            List<DeviceDesc> assetList = new ArrayList<>();
            for (ImcItemInvoiceDevice imcItemInvoiceDevice : imcItemInvoiceDevices) {
                DeviceDesc deviceDesc = new DeviceDesc();
                BeanUtils.copyProperties(imcItemInvoiceDevice,deviceDesc);
                assetList.add(deviceDesc);
            }
            formDataDto.setAssetList(assetList);
        }
        // 回显巡检内容列表项
        Example example1 = new Example(ImcItemInvoiceDevice.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("invoiceId",invoiceId);
        example1.setOrderByClause("`sort` ASC");
        List<ImcItemInvoiceDesc> imcItemInvoiceDescs = imcItemInvoiceDescMapper.selectByExample(example1);
        if (imcItemInvoiceDescs != null) {
            List<InspcDetail> inspcDetailList = new ArrayList<>();
            for (ImcItemInvoiceDesc imcItemInvoiceDesc : imcItemInvoiceDescs) {
                InspcDetail inspcDetail = new InspcDetail();
                BeanUtils.copyProperties(imcItemInvoiceDesc,inspcDetail);
                inspcDetailList.add(inspcDetail);
            }
            formDataDto.setInspcDetailList(inspcDetailList);
        }
        return formDataDto;
    }

    @Override
    public Integer saveData(FormDataDto formDataDto, LoginAuthDto loginAuthDto) {
        // 更新巡检单详情
        ImcItemInvoice imcItemInvoice = new ImcItemInvoice();
        BeanUtils.copyProperties(formDataDto.getFeedback(),imcItemInvoice);
        BeanUtils.copyProperties(formDataDto,imcItemInvoice);
        imcItemInvoice.setUpdateInfo(loginAuthDto);
        // 该巡检单已填写
        imcItemInvoice.setStatus("Y");
        imcItemInvoiceMapper.updateByPrimaryKeySelective(imcItemInvoice);
        // 更新资产列表详情
        List<DeviceDesc> assetList = formDataDto.getAssetList();
        if (assetList != null) {
            for (DeviceDesc deviceDesc : assetList) {
                ImcItemInvoiceDevice imcItemInvoiceDevice = new ImcItemInvoiceDevice();
                BeanUtils.copyProperties(deviceDesc,imcItemInvoiceDevice);
                imcItemInvoiceDevice.setUpdateInfo(loginAuthDto);
                imcItemInvoiceDeviceMapper.updateByPrimaryKeySelective(imcItemInvoiceDevice);
            }
        }
        // 更新巡检详情列表
        List<InspcDetail> inspcDetailList = formDataDto.getInspcDetailList();
        if (inspcDetailList != null) {
            for (InspcDetail inspcDetail : inspcDetailList) {
                ImcItemInvoiceDesc imcItemInvoiceDesc = new ImcItemInvoiceDesc();
                BeanUtils.copyProperties(inspcDetail,imcItemInvoiceDesc);
                imcItemInvoiceDesc.setUpdateInfo(loginAuthDto);
                imcItemInvoiceDescMapper.updateByPrimaryKeySelective(imcItemInvoiceDesc);
            }
        }
        // 更新巡检子项中巡检单的结果
        ImcItemInvoice queryInvoice = imcItemInvoiceMapper.selectByPrimaryKey(formDataDto.getId());
        Long inspecItemId = queryInvoice.getInspcItemId();
        ImcItemInvoice query = new ImcItemInvoice();
        query.setInspcItemId(inspecItemId);
        query.setStatus("N");
        int count = imcItemInvoiceMapper.selectCount(query);
        ImcInspectionItem imcInspectionItem = new ImcInspectionItem();
        imcInspectionItem.setId(inspecItemId);
        if (count == 0) {
            imcInspectionItem.setResult("finish");
        } else {
            imcInspectionItem.setResult(String.valueOf(count));
        }
        imcInspectionItemMapper.updateByPrimaryKeySelective(imcInspectionItem);
        return null;
    }
}
