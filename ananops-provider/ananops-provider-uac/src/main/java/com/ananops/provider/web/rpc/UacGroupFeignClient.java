package com.ananops.provider.web.rpc;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.UacGroup;
import com.ananops.provider.model.dto.group.GroupSaveDto;
import com.ananops.provider.model.dto.group.GroupStatusDto;
import com.ananops.provider.model.dto.user.IdStatusDto;
import com.ananops.provider.model.service.UacGroupFeignApi;
import com.ananops.provider.service.UacGroupService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作Group
 *
 * Created by bingyueduan on 2019/12/29.
 */
@RestController
@Api(value = "API - UacGroupFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacGroupFeignClient extends BaseController implements UacGroupFeignApi {

    @Resource
    private UacGroupService uacGroupService;

    @Override
    @ApiOperation(httpMethod = "POST", value = "编辑用户组")
    public Wrapper<Long> groupSave(@RequestBody GroupSaveDto groupSaveDto) {
        LoginAuthDto loginAuthDto = super.getLoginAuthDto();
        UacGroup uacGroup = new UacGroup();
        uacGroup.setGroupCode(groupSaveDto.getGroupCode());
        uacGroup.setGroupName(groupSaveDto.getGroupName());
        uacGroup.setContact(groupSaveDto.getContactName());
        uacGroup.setContactPhone(groupSaveDto.getContactPhone());
        uacGroupService.saveUacGroup(uacGroup, loginAuthDto);
        UacGroup result = uacGroupService.selectOne(uacGroup);
        return WrapMapper.ok(result.getId());
    }

    @Override
    public Wrapper<Integer> modifyGroupStatus(@RequestBody IdStatusDto idStatusDto) {
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        int result = uacGroupService.updateUacGroupStatusById(idStatusDto, loginAuthDto);
        return WrapMapper.ok(result);
    }

    @Override
    public Wrapper<List<GroupSaveDto>> queryListByStatus(@RequestBody GroupStatusDto groupStatusDto) {
        List<GroupSaveDto> result = new ArrayList<>();
        UacGroup uacGroup = new UacGroup();
        try {
            BeanUtils.copyProperties(uacGroup, groupStatusDto);
        } catch (Exception e) {
            logger.error("用户组Dto与用户组状态传输Dto属性拷贝异常");
            e.printStackTrace();
        }
        List<UacGroup> groups = uacGroupService.select(uacGroup);
        for (UacGroup uacGroupT : groups) {
            GroupSaveDto groupSaveDto = new GroupSaveDto();
            try {
                BeanUtils.copyProperties(groupSaveDto, uacGroupT);
            } catch (Exception e) {
                logger.error("用户组Dto与用户组传输Dto属性拷贝异常");
                e.printStackTrace();
            }
            result.add(groupSaveDto);
        }
        return WrapMapper.ok(result);
    }
}
