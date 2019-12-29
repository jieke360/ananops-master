package com.ananops.provider.service;

import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.SpcCompany;
import com.ananops.provider.model.dto.CompanyDto;

import java.util.List;

/**
 * 操作加盟服务商Company的Service接口
 *
 * Created by bingyueduan on 2019/12/28.
 */
public interface SpcCompanyService extends IService<SpcCompany> {

    /**
     * 根据服务商Id查询服务商
     *
     * @param companyDto
     * @return
     */
    int getCompanyById(CompanyDto companyDto);

    /**
     * 查询所有服务商列表
     *
     * @param spcCompany
     * @return
     */
    List<SpcCompany> queryAllCompanys(SpcCompany spcCompany);

}
