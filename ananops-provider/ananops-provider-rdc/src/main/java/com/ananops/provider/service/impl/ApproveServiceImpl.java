package com.ananops.provider.service.impl;

import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.ApproveMapper;
import com.ananops.provider.model.domain.Approve;
import com.ananops.provider.service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproveServiceImpl extends BaseService<Approve> implements ApproveService {
    @Autowired
    ApproveMapper approveMapper;
    
    @Override
    public Boolean createNewApprove(Approve approve) {
        return null;
    }
    
    @Override
    public Boolean approve(Approve approve) {
        return null;
    }
    
    @Override
    public List<Approve> getAllApproveByApproverId(Long approverId) {
        return null;
    }
    
    @Override
    public Approve getApproveById(Long id) {
        return null;
    }
    
    public  Approve getOnProcessingApprove(Long approveId, Integer objectType, Long objectId) {
        return approveMapper.selectOnProcessingApprove(approveId, objectType, objectId);
    }
}
