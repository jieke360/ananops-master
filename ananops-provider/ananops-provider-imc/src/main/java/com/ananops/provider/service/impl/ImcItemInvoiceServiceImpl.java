package com.ananops.provider.service.impl;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.ImcItemInvoiceMapper;
import com.ananops.provider.model.domain.ImcItemInvoice;
import com.ananops.provider.model.dto.ImcInvoiceQueryDto;
import com.ananops.provider.service.ImcItemInvoiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
}
