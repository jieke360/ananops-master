package com.ananops.provider.service;

import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.SpcEngineer;
import com.ananops.provider.model.dto.EngineerDto;

import java.util.List;

/**
 * 操作加盟服务商Engineer的Service接口
 *
 * Created by bingyueduan on 2019/12/30.
 */
public interface SpcEngineerService extends IService<SpcEngineer> {

    /**
     * 根据项目id查询该项目下工程师集合
     *
     * @param projectId 项目Id
     *
     * @return 返回工程师信息集合
     */
    List<EngineerDto> getEngineersByProjectId(Long projectId);

    /**
     * 根据传入的工程师Id查询工程师信息
     *
     * @param engineerId 工程师Id
     *
     * @return 返回工程师信息
     */
    EngineerDto getEngineerById(Long engineerId);

    /**
     * 根据传入的批量工程师Id查询工程师信息集合
     *
     * @param engineerIdList 工程师ID集合
     *
     * @return 返回工程师信息集合
     */
    List<EngineerDto> getEngineersByBatchId(List<Long> engineerIdList);

}
