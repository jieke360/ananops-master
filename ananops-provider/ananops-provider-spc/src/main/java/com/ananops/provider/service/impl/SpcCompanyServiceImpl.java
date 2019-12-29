package com.ananops.provider.service.impl;

import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.SpcCompanyMapper;
import com.ananops.provider.model.domain.SpcCompany;
import com.ananops.provider.model.dto.CompanyDto;
import com.ananops.provider.model.vo.CompanyVo;
import com.ananops.provider.service.SpcCompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作加盟服务商Company的Service接口实现类
 *
 * Created by bingyueduan on 2019/12/28.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SpcCompanyServiceImpl extends BaseService<SpcCompany> implements SpcCompanyService {

    @Resource
    private SpcCompanyMapper spcCompanyMapper;

    @Override
    public int getCompanyById(CompanyDto companyDto) {
        return spcCompanyMapper.selectCount(new SpcCompany());
    }

    @Override
    public List<SpcCompany> queryAllCompanys(SpcCompany spcCompany) {
        return spcCompanyMapper.select(spcCompany);
    }
}
