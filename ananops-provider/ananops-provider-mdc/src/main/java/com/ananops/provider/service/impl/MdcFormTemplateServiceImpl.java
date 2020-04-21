package com.ananops.provider.service.impl;

import com.ananops.PublicUtil;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.MdcFormTemplateItemMapper;
import com.ananops.provider.mapper.MdcFormTemplateMapper;
import com.ananops.provider.model.domain.MdcFormTemplate;
import com.ananops.provider.model.domain.MdcFormTemplateItem;
import com.ananops.provider.model.dto.MdcDeviceDesc;
import com.ananops.provider.model.dto.MdcFormDataDto;
import com.ananops.provider.model.dto.MdcInspcDetail;
import com.ananops.provider.service.MdcFormTemplateService;
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
 * @date 2020/4/20 下午3:31
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MdcFormTemplateServiceImpl extends BaseService<MdcFormTemplate> implements MdcFormTemplateService {

    @Resource
    private MdcFormTemplateMapper mdcFormTemplateMapper;

    @Resource
    private MdcFormTemplateItemMapper mdcFormTemplateItemMapper;

    @Override
    public Integer saveFormTemplate(MdcFormDataDto mdcFormDataDto, LoginAuthDto loginAuthDto) {
        if (mdcFormDataDto.getTemplateId() == null) {
            logger.info("创建一条动态表单模板... mdcFormDataDto = {}", mdcFormDataDto);

            Long templateId = super.generateId();
            MdcFormTemplate mdcFormTemplate = new MdcFormTemplate();
            mdcFormTemplate.setId(templateId);
            mdcFormTemplate.setSchemaId(mdcFormDataDto.getSchemaId());
            mdcFormTemplate.setDr(String.valueOf(0));
            if (loginAuthDto.getGroupId().equals(1L)) {
                mdcFormTemplate.setGroupId(-1L);
            } else {
                mdcFormTemplate.setGroupId(loginAuthDto.getGroupId());
            }
            mdcFormTemplateMapper.insert(mdcFormTemplate);
            // 存储所有子项
            insertTemplateItem(mdcFormDataDto, templateId);
        } else {
            logger.info("编辑一条动态表单模板... mdcFormDataDto = {}", mdcFormDataDto);
            MdcFormTemplate query = new MdcFormTemplate();
            query.setId(mdcFormDataDto.getTemplateId());
            MdcFormTemplate mdcFormTemplate = mdcFormTemplateMapper.selectByPrimaryKey(query);
            if (mdcFormTemplate == null) {
                throw new BusinessException(ErrorCodeEnum.MDC10021037,mdcFormDataDto.getTemplateId());
            }
            // 先删除所有模板子项
            Example example = new Example(MdcFormTemplateItem.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("templateId", mdcFormTemplate.getId());
            mdcFormTemplateItemMapper.deleteByExample(example);
            // 重新存储所有子项内容
            insertTemplateItem(mdcFormDataDto, mdcFormTemplate.getId());
        }

        return null;
    }

    // 插入模板子项工具类
    private void insertTemplateItem(MdcFormDataDto mdcFormDataDto, Long templateId) {
        List<MdcDeviceDesc> mdcDeviceDescs = mdcFormDataDto.getAssetList();
        List<MdcInspcDetail> mdcInspcDetails = mdcFormDataDto.getInspcDetailList();
        // 存储资产列表模板子项
        if (mdcDeviceDescs != null) {
            for (MdcDeviceDesc mdcDeviceDesc : mdcDeviceDescs) {
                Long deviceItemId = super.generateId();
                MdcFormTemplateItem mdcFormTemplateItem = new MdcFormTemplateItem();
                mdcFormTemplateItem.setId(deviceItemId);
                mdcFormTemplateItem.setTemplateId(templateId);
                mdcFormTemplateItem.setType("device");
                mdcFormTemplateItem.setContent(mdcDeviceDesc.getDevice());
                mdcFormTemplateItemMapper.insert(mdcFormTemplateItem);
            }
        }
        // 存储巡检内容模板子项
        if (mdcInspcDetails != null) {
            for (MdcInspcDetail mdcInspcDetail : mdcInspcDetails) {
                Long itemId = super.generateId();
                MdcFormTemplateItem mdcFormTemplateItem = new MdcFormTemplateItem();
                mdcFormTemplateItem.setId(itemId);
                mdcFormTemplateItem.setTemplateId(templateId);
                mdcFormTemplateItem.setType("inspcContent");
                mdcFormTemplateItem.setContent(mdcInspcDetail.getItemContent());
                mdcFormTemplateItemMapper.insert(mdcFormTemplateItem);
            }
        }
    }

    @Override
    public Integer updateFormTemplate(MdcFormTemplate mdcFormTemplate, LoginAuthDto loginAuthDto) {
        mdcFormTemplate.setUpdateInfo(loginAuthDto);
        // 首先增量更新变动项
        mdcFormTemplateMapper.updateByPrimaryKeySelective(mdcFormTemplate);

        // 如果项目名称或者项目Id为空时取消关联
        if (PublicUtil.isEmpty(mdcFormTemplate.getProjectId()) || PublicUtil.isEmpty(mdcFormTemplate.getProjectName())) {
            MdcFormTemplate mdcFormTemplateRecord = mdcFormTemplateMapper.selectByPrimaryKey(mdcFormTemplate);
            mdcFormTemplateRecord.setUpdateInfo(loginAuthDto);
            mdcFormTemplateRecord.setProjectId(null);
            mdcFormTemplateRecord.setProjectName(null);
            mdcFormTemplateMapper.updateByPrimaryKey(mdcFormTemplateRecord);
        }
        return null;
    }

    @Override
    public List<MdcFormTemplate> getFormTemplateList(LoginAuthDto loginAuthDto) {
        // 这里默认只能管理员登录，管理员账号直接挂在公司组织下的，所以用户组织就是公司组织
        Long groupId = loginAuthDto.getGroupId();
        List<MdcFormTemplate> res = new ArrayList<>();
        List<MdcFormTemplate> mdcFormTemplates = mdcFormTemplateMapper.selectByDefault();
        if (mdcFormTemplates.size()>0){
            res.addAll(mdcFormTemplates);
        }
        if (groupId!=null){
            List<MdcFormTemplate> mdcFormTemplates1 = mdcFormTemplateMapper.selectBygroupId(groupId);
            if(mdcFormTemplates1.size()>0){
                res.addAll(mdcFormTemplates1);
            }
        }
        return res;
    }

    @Override
    public MdcFormTemplate queryById(Long templateId) {
        return mdcFormTemplateMapper.selectByPrimaryKey(templateId);
    }

    @Override
    public MdcFormDataDto queryDetailsById(Long templateId) {
        MdcFormDataDto mdcFormDataDto = new MdcFormDataDto();
        MdcFormTemplate mdcFormTemplate = mdcFormTemplateMapper.selectByPrimaryKey(templateId);
        if (mdcFormTemplate == null) {
            throw new BusinessException(ErrorCodeEnum.MDC10021037,templateId);
        }
        mdcFormDataDto.setTemplateId(mdcFormTemplate.getId());
        mdcFormDataDto.setSchemaId(mdcFormTemplate.getSchemaId());
        // 回显设备列表项
        Example example = new Example(MdcFormTemplateItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("templateId", mdcFormTemplate.getId());
        criteria.andEqualTo("type", "device");
        List<MdcFormTemplateItem> devices = mdcFormTemplateItemMapper.selectByExample(example);
        if (devices != null) {
            List<MdcDeviceDesc> mdcDeviceDescs = new ArrayList<>();
            for (MdcFormTemplateItem mdcFormTemplateItem : devices) {
                MdcDeviceDesc mdcDeviceDesc = new MdcDeviceDesc();
                mdcDeviceDesc.setDevice(mdcFormTemplateItem.getContent());
                mdcDeviceDescs.add(mdcDeviceDesc);
            }
            mdcFormDataDto.setAssetList(mdcDeviceDescs);
        }
        // 回显巡检内容项列表
        Example example1 = new Example(MdcFormTemplateItem.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("templateId", mdcFormTemplate.getId());
        criteria1.andEqualTo("type", "inspcContent");
        List<MdcFormTemplateItem> inspcs = mdcFormTemplateItemMapper.selectByExample(example1);
        if (inspcs != null) {
            List<MdcInspcDetail> mdcInspcDetails = new ArrayList<>();
            for (MdcFormTemplateItem mdcFormTemplateItem : inspcs) {
                MdcInspcDetail mdcInspcDetail = new MdcInspcDetail();
                mdcInspcDetail.setItemContent(mdcFormTemplateItem.getContent());
                mdcInspcDetails.add(mdcInspcDetail);
            }
            mdcFormDataDto.setInspcDetailList(mdcInspcDetails);
        }
        return mdcFormDataDto;
    }

    @Override
    public Integer deleteById(Long templateId) {
        MdcFormTemplate mdcFormTemplate = mdcFormTemplateMapper.selectByPrimaryKey(templateId);
        if (mdcFormTemplate == null) {
            throw new BusinessException(ErrorCodeEnum.MDC10021037,templateId);
        }
        // 先删除所有模板子项
        Example example = new Example(MdcFormTemplateItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("templateId", mdcFormTemplate.getId());
        mdcFormTemplateItemMapper.deleteByExample(example);
        // 再删除模板
        return mdcFormTemplateMapper.deleteByPrimaryKey(mdcFormTemplate.getId());
    }
}
