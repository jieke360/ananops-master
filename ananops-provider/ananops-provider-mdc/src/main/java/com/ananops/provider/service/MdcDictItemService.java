package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.MdcSysDictItem;
import com.ananops.provider.model.dto.MdcAddDictItemDto;

import java.util.List;

/**
 * Created by huqiaoqian on 2020/3/27
 */
public interface MdcDictItemService extends IService<MdcSysDictItem> {
    /**
     * 创建/编辑字典项
     * @param addDictItemDto
     * @param loginAuthDto
     * @return
     */
    MdcAddDictItemDto saveItem(MdcAddDictItemDto addDictItemDto, LoginAuthDto loginAuthDto);

    /**
     * 根据字典库id获取字典项列表
     * @param dictId
     * @return
     */
    List<MdcSysDictItem> getDictItemListByDictId(Long dictId);

    /**
     * 根据字典项id删除字典项
     * @param itemId
     * @return
     */
    MdcSysDictItem deleteDictItemByItemId(Long itemId,LoginAuthDto loginAuthDto);
}
