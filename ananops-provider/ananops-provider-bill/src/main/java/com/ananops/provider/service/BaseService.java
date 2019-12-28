package com.ananops.provider.service;

import com.ananops.provider.model.domain.Basebill;

import java.util.List;

public interface BaseService {
    public String insert(String body);
    public List<Basebill> getAllBillByUserId(String userid);
    public Float getAmountByworkorderid(String workorderid);
    public Basebill getBillById(String id);
    public void modifyAmount(Basebill basebill, Float modifyAmount);
    public List<Basebill> getAllUBillBystate(String userid, String state);
}


