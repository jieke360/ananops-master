package com.ananops.provider.web.rpc;

import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.UacRole;
import com.ananops.provider.model.domain.UacUser;
import com.ananops.provider.model.service.UacUserInfoFeignApi;
import com.ananops.provider.model.user.UserInfoDto;
import com.ananops.provider.service.UacRoleService;
import com.ananops.provider.service.UacUserService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@RestController
@Api(value = "API - UacUserInfoFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacUserInfoFeignClient extends BaseController implements UacUserInfoFeignApi {

    @Resource
    private UacUserService uacUserService;
    @Resource
    private UacRoleService uacRoleService;

    @Override
    @ApiOperation(httpMethod = "POST", value = "根据用户id查询用户详细信息")
    public Wrapper<UserInfoDto> queryUserInfoById(@RequestParam Long id) {
        logger.info("根据用户id查询用户详细信息");
        UserInfoDto userInfoVo = new UserInfoDto();
        UacUser uacUser = uacUserService.findUserInfoByUserId(id);
        BeanUtils.copyProperties(uacUser, userInfoVo);
        List<UacRole> roleList = uacRoleService.findAllRoleInfoByUserId(id);
        Iterator<UacRole> iterator = roleList.iterator();
        if (iterator.hasNext()) {
            UacRole uacRole = iterator.next();
            userInfoVo.setRoleId(uacRole.getId());
            userInfoVo.setRoleName(uacRole.getRoleName());
            userInfoVo.setRoleCode(uacRole.getRoleCode());
            userInfoVo.setRoleStatus(uacRole.getStatus());
        }
        return WrapMapper.ok(userInfoVo);
    }
}
