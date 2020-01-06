package com.ananops.provider.service;

import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.Approve;

import java.util.List;

public interface ApproveService extends IService<Approve> {
    
    Boolean createNewApprove(Approve approve);
    
    Boolean approve(Approve approve);
    
    List<Approve> getAllApproveByApproverId(Long approverId);
    
    Approve getApproveById(Long id);
    
    Approve getOnProcessingApprove(Long approveId, Integer objectType, Long objectId);
}
