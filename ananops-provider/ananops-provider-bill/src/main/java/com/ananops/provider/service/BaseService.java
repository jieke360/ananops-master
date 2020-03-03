package com.ananops.provider.service;

import com.ananops.provider.model.domain.BmcBill;
import com.ananops.provider.model.dto.BillCreateDto;
import com.ananops.provider.model.dto.BillDisplayDto;

import java.util.List;

public interface BaseService {
    public void insert(BillCreateDto billCreateDto, Float devicePrice, Float servicePrice, String transactionMethod);
    public List<BillDisplayDto> getAllBillByUserId(Long userId);
    public Float getAmountByWorkOrderId(Long workOrderId);
    public BmcBill getBillById(Long id);
    public void modifyAmount(BmcBill bmcBill, Float modifyAmount);
    public List<BmcBill> getAllUBillByState(Long userId, String state);
    List<BmcBill> getBillByWorkOrderId(Long workOrderId);
}


