package com.ananops.provider.service.impl;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.MdcSysDictItemMapper;
import com.ananops.provider.mapper.MdcSysDictMapper;
import com.ananops.provider.model.domain.MdcSysDict;
import com.ananops.provider.model.domain.MdcSysDictItem;
import com.ananops.provider.model.dto.MdcAddDictItemDto;
import com.ananops.provider.service.MdcDictItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huqiaoqian on 2020/3/27
 */
@Slf4j
@Service
public class MdcDictItemServiceImpl extends BaseService<MdcSysDictItem> implements MdcDictItemService {
    @Resource
    MdcSysDictItemMapper dictItemMapper;

    @Resource
    MdcSysDictMapper dictMapper;

    @Override
    public MdcAddDictItemDto saveItem(MdcAddDictItemDto addDictItemDto, LoginAuthDto loginAuthDto) {
        MdcSysDictItem dictItem=new MdcSysDictItem();
        BeanUtils.copyProperties(addDictItemDto,dictItem);
        dictItem.setUpdateInfo(loginAuthDto);
        Long dictId = dictItem.getDictId();
        if (dictId==null){
            throw new BusinessException(ErrorCodeEnum.MDC10021026);
        }
        Example example = new Example(MdcSysDict.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",dictId);
        List<MdcSysDict> dictList =dictMapper.selectByExample(example);
        if(dictList.size()==0){//如果没有此字典库
            throw new BusinessException(ErrorCodeEnum.MDC10021024,dictId);
        }
        if(addDictItemDto.getId()==null){//如果是新增一条字典项记录
            Long itemId = super.generateId();
            dictItem.setId(itemId);
            dictItem.setDr(String.valueOf(0));
            dictItemMapper.insert(dictItem);
            BeanUtils.copyProperties(dictItem,addDictItemDto);
        }else{//如果是更新已经存在的字典项
            Long itemId=addDictItemDto.getId();
            Example example1 = new Example(MdcSysDictItem.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("id",itemId);
            List<MdcSysDictItem> dictItemList =dictItemMapper.selectByExample(example1);
            if(dictItemList.size()==0){//如果没有此字典项
                throw new BusinessException(ErrorCodeEnum.MDC10021025,itemId);
            }
            dictItemMapper.updateByPrimaryKeySelective(dictItem);
            BeanUtils.copyProperties(dictItem,addDictItemDto);
        }
        return addDictItemDto;
    }

    @Override
    public List<MdcSysDictItem> getDictItemListByDictId(Long dictId) {

        if (dictId==null){
            throw new BusinessException(ErrorCodeEnum.MDC10021026);
        }

        return dictItemMapper.selectBygDictId(dictId);
    }

    @Override
    public MdcSysDictItem deleteDictItemByItemId(Long itemId,LoginAuthDto loginAuthDto) {
        if(itemId==null){
            throw new BusinessException(ErrorCodeEnum.MDC10021027);
        }

        MdcSysDictItem dictItem=dictItemMapper.selectByPrimaryKey(itemId);
        if (dictItem==null){
            throw new BusinessException(ErrorCodeEnum.MDC10021025,itemId);
        }
        dictItem.setUpdateInfo(loginAuthDto);
        dictItem.setDr(String.valueOf(1));
        dictItemMapper.updateByPrimaryKeySelective(dictItem);
        return dictItem;
    }
}
