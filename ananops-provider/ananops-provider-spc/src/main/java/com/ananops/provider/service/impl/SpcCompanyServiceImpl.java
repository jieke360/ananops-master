package com.ananops.provider.service.impl;

import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.SpcCompanyMapper;
import com.ananops.provider.model.domain.SpcCompany;
import com.ananops.provider.model.dto.CompanyDto;
import com.ananops.provider.model.dto.CompanyRegisterDto;
import com.ananops.provider.model.dto.CompanyStatusDto;
import com.ananops.provider.model.dto.ModifyCompanyStatusDto;
import com.ananops.provider.model.dto.group.GroupSaveDto;
import com.ananops.provider.model.dto.group.GroupStatusDto;
import com.ananops.provider.model.dto.user.IdStatusDto;
import com.ananops.provider.model.dto.user.UserRegisterDto;
import com.ananops.provider.model.service.UacGroupFeignApi;
import com.ananops.provider.model.service.UacUserFeignApi;
import com.ananops.provider.model.vo.CompanyVo;
import com.ananops.provider.service.SpcCompanyService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 操作加盟服务商Company的Service接口实现类
 *
 * Created by bingyueduan on 2019/12/28.
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SpcCompanyServiceImpl extends BaseService<SpcCompany> implements SpcCompanyService {

    @Resource
    private SpcCompanyMapper spcCompanyMapper;

    @Resource
    private UacUserFeignApi uacUserFeignApi;

    @Resource
    private UacGroupFeignApi uacGroupFeignApi;

    @Override
    public int getCompanyById(CompanyDto companyDto) {
        return spcCompanyMapper.selectCount(new SpcCompany());
    }

    @Override
    public List<SpcCompany> queryAllCompanys(SpcCompany spcCompany) {
        return spcCompanyMapper.select(spcCompany);
    }

    @Override
    public void register(CompanyRegisterDto company) {
        // 校验注册信息
        validateRegisterInfo(company);
        // 构建UAC User注册Dto
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        try {
            BeanUtils.copyProperties(userRegisterDto, company);
        } catch (Exception e) {
            logger.error("服务商Dto与用户Dto属性拷贝异常");
            e.printStackTrace();
        }
        Long uacUserId = uacUserFeignApi.userRegister(userRegisterDto).getResult();

        GroupSaveDto groupSaveDto = new GroupSaveDto();
        groupSaveDto.setGroupName(company.getLoginName());
        groupSaveDto.setGroupCode(company.getCompanyUscc());
        groupSaveDto.setContactName(company.getContactName());
        groupSaveDto.setContactPhone(company.getMobileNo());
        Long uacGroupId = uacGroupFeignApi.groupSave(groupSaveDto).getResult();

        if (!StringUtils.isEmpty(uacUserId) && !StringUtils.isEmpty(uacGroupId)) {
            Date row = new Date();
            // 封装注册信息
            long id = generateId();
            SpcCompany spcCompany = new SpcCompany();
            spcCompany.setId(id);
            spcCompany.setGroupId(uacGroupId);
            spcCompany.setUserId(uacUserId);
            spcCompany.setCreatorId(id);
            spcCompany.setCreator(company.getLoginName());
            spcCompany.setLastOperatorId(id);
            spcCompany.setLastOperator(company.getLoginName());
            logger.info("注册服务商. SpcCompany={}", spcCompany);
            spcCompanyMapper.insertSelective(spcCompany);
        }
    }

    private void validateRegisterInfo(CompanyRegisterDto companyRegisterDto) {
        String mobileNo = companyRegisterDto.getMobileNo();

        Preconditions.checkArgument(!StringUtils.isEmpty(companyRegisterDto.getLoginName()), ErrorCodeEnum.UAC10011007.msg());
        Preconditions.checkArgument(!StringUtils.isEmpty(companyRegisterDto.getEmail()), ErrorCodeEnum.UAC10011018.msg());
        Preconditions.checkArgument(!StringUtils.isEmpty(companyRegisterDto.getCompanyUscc()), ErrorCodeEnum.UAC100150010.msg());
        Preconditions.checkArgument(!StringUtils.isEmpty(mobileNo), "手机号不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyRegisterDto.getLoginPwd()), ErrorCodeEnum.UAC10011014.msg());
        Preconditions.checkArgument(!StringUtils.isEmpty(companyRegisterDto.getConfirmPwd()), ErrorCodeEnum.UAC10011009.msg());
        Preconditions.checkArgument(!StringUtils.isEmpty(companyRegisterDto.getPhoneSmsCode()), "短信验证码不能为空");
        Preconditions.checkArgument(companyRegisterDto.getLoginPwd().equals(companyRegisterDto.getConfirmPwd()), "两次密码不一致");
    }

    @Override
    public int modifyUserStatusById(ModifyCompanyStatusDto modifyCompanyStatusDto) {
        Long companyId = modifyCompanyStatusDto.getCompanyId();
        String status = modifyCompanyStatusDto.getStatus();
        if (!StringUtils.isEmpty(companyId) && !StringUtils.isEmpty(status)) {
            Long uacGroupId = spcCompanyMapper.selectByPrimaryKey(companyId).getGroupId();
            IdStatusDto modifyGroupStatusDto = new IdStatusDto();
            modifyCompanyStatusDto.setCompanyId(uacGroupId);
            modifyCompanyStatusDto.setStatus(status);
            return (int)uacGroupFeignApi.modifyGroupStatus(modifyGroupStatusDto).getResult();
        }
        return 0;
    }

    @Override
    public List<CompanyVo> queryListByStatus(CompanyStatusDto companyStatusDto) {
        List<CompanyVo> results = new ArrayList<>();
        GroupStatusDto groupStatusDto = new GroupStatusDto();
        try {
            BeanUtils.copyProperties(groupStatusDto, companyStatusDto);
        } catch (Exception e) {
            logger.error("服务商Dto与用户组Dto属性拷贝异常");
            e.printStackTrace();
        }
        List<GroupSaveDto> groupSaveDtos = uacGroupFeignApi.queryListByStatus(groupStatusDto).getResult();
        for (GroupSaveDto groupSaveDto : groupSaveDtos) {
            Long groupId = groupSaveDto.getId();
            CompanyVo companyVo = new CompanyVo();
            SpcCompany getSpcCompany = new SpcCompany();
            getSpcCompany.setGroupId(groupId);
            SpcCompany spcCompany = spcCompanyMapper.selectOne(getSpcCompany);
            try {
                BeanUtils.copyProperties(companyVo, groupSaveDto);
                BeanUtils.copyProperties(companyVo, spcCompany);
            } catch (Exception e) {
                logger.error("服务商Dto与用户组Dto属性拷贝异常");
                e.printStackTrace();
            }
            results.add(companyVo);
        }
        return results;
    }
}
