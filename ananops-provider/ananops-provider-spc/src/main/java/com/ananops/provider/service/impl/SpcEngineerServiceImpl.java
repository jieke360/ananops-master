package com.ananops.provider.service.impl;

import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.SpcEngineerMapper;
import com.ananops.provider.model.domain.SpcEngineer;
import com.ananops.provider.model.dto.EngineerDto;
import com.ananops.provider.model.dto.user.UserInfoDto;
import com.ananops.provider.model.service.UacUserFeignApi;
import com.ananops.provider.service.PmcProjectEngineerFeignApi;
import com.ananops.provider.service.SpcEngineerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 操作加盟服务商Engineer的Service接口实现类
 *
 * Created by bingyueduan on 2019/12/30.
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SpcEngineerServiceImpl extends BaseService<SpcEngineer> implements SpcEngineerService {

    @Resource
    private SpcEngineerMapper spcEngineerMapper;

    @Resource
    private PmcProjectEngineerFeignApi pmcProjectEngineerFeignApi;

    @Resource
    private UacUserFeignApi uacUserFeignApi;

    @Override
    public List<EngineerDto> getEngineersByProjectId(Long projectId) {
        List<EngineerDto> result = new ArrayList<>();
        List<Long> engineersId = pmcProjectEngineerFeignApi.getEngineersIdByProjectId(projectId).getResult();
        for (Long engineerId : engineersId) {
            result.add(getEngineerDto(engineerId));
        }
        return result;
    }

    @Override
    public EngineerDto getEngineerById(Long engineerId) {
        return getEngineerDto(engineerId);
    }

    @Override
    public List<EngineerDto> getEngineersByBatchId(List<Long> engineerIdList) {
        List<EngineerDto> result = new ArrayList<>();
        for (Long engineerId : engineerIdList) {
            result.add(getEngineerDto(engineerId));
        }
        return result;
    }

    /**
     * 组合SPC模块的Engineer对象和UAC模块的User对象.
     *
     * @param spcEngineer SPC模块的Engineer对象
     *
     * @param userInfoDto UAC模块的User对象
     *
     * @return  返回一个组拼完整信息的工程师信息
     */
    private EngineerDto getEngineerDto(Long engineerId) {
        EngineerDto engineerDto = new EngineerDto();
        if (StringUtils.isEmpty(engineerId))
            return engineerDto;
        SpcEngineer fx = new SpcEngineer();
        fx.setId(engineerId);
        SpcEngineer spcEngineer = spcEngineerMapper.selectOne(fx);
        if (spcEngineer != null) {
            Long userId = spcEngineer.getUserId();
            UserInfoDto userInfoDto = uacUserFeignApi.getUacUserById(userId).getResult();
            if (userInfoDto != null) {
                try {
                    BeanUtils.copyProperties(engineerDto, spcEngineer);
                    BeanUtils.copyProperties(engineerDto, userInfoDto);
                } catch (Exception e) {
                    logger.error("工程师Dto与用户Dto属性拷贝异常");
                    e.printStackTrace();
                }
            }
        }
        return engineerDto;
    }
}
