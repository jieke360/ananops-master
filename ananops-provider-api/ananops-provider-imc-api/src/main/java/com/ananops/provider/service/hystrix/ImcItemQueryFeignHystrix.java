package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.ItemDto;
import com.ananops.provider.service.ImcItemQueryFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by rongshuai on 2019/12/18 10:57
 */
@Component
public class ImcItemQueryFeignHystrix implements ImcItemQueryFeignApi {

    @Override
    public Wrapper<List<ItemDto>> getByProjectId(Long projectId){
        return null;
    }
}
