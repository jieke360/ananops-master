package com.ananops.provider.model.vo;

import com.ananops.base.dto.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 加盟服务商查询返回的Vo
 *
 * Created by bingyueduan on 2019/12/28.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyVo extends BaseVo {

    private static final long serialVersionUID = -6330126377475850151L;

    /**
     * 经营范围
     */
    private String businessScope;
}
