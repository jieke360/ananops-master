package com.ananops.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ananops.provider.mapper.BasebillMapper;
import com.ananops.provider.model.domain.Basebill;
import com.ananops.provider.model.dto.PmcPayDto;
import com.ananops.provider.service.BaseService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    BasebillMapper basebillMapper;

    @Override
    public String insert(String body) {
        JSONObject jsonObject=JSONObject.parseObject(body);
        String paymentMethod=jsonObject.get("paymentMethod").toString();
        String userid=jsonObject.get("userid").toString();
        String workorderid=jsonObject.get("workorderid").toString();
        String supplier=jsonObject.get("supplier").toString();
        //TODO
        Float amount=Float.valueOf(jsonObject.get("amount").toString());
        String transactionMethod=jsonObject.get("transactionMethod").toString();
        String payDto = jsonObject.get("payDto").toString();
        JsonObject jsonObject1 = new JsonParser().parse(payDto).getAsJsonObject();
        Date date=new Date();
        Long time=date.getTime();
        Basebill bill = new Basebill();
        Long timestamp = System.currentTimeMillis();
        String id = String.valueOf(timestamp)+userid;
        bill.setId(id);
        bill.setPaymentMethod(paymentMethod);
        bill.setTransactionMethod(jsonObject1.get("paymentType").getAsString());
        bill.setAmount(jsonObject1.get("paymentMoney").getAsFloat());
        bill.setUserid(userid);
        bill.setTime(time);
        bill.setSupplier(supplier);
        bill.setWorkorderid(workorderid);
        basebillMapper.insertSelective(bill);

        return null;
    }

    @Override
    public List<Basebill> getAllBillByUserId(String userid) {
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(userid);
        return basebillMapper.selectByExample(example);
    }

    @Override
    public Float getAmountByworkorderid(String workorderid) {
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(workorderid);
        List<Basebill> list = basebillMapper.selectByExample(example);
        Basebill basebill = list.get(0);
        return basebill.getAmount();
    }

    @Override
    public Basebill getBillById(String id) {
        return basebillMapper.selectByPrimaryKey(id);
    }

    @Override
    public void modifyAmount(Basebill basebill, Float modifyAmount) {
        basebill.setAmount(modifyAmount);
        basebillMapper.updateByPrimaryKey(basebill);

    }

    @Override
    public List<Basebill> getAllUBillBystate(String userid, String state) {
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(userid);
        List<Basebill> list = basebillMapper.selectByExample(example);
        List<Basebill> listnew = new ArrayList<>();
        if(list != null && list.size()>0){
            for(Basebill basebill:list){
                if(basebill.getState().equals(state)){
                    listnew.add(basebill);
                }
            }
        }
        return listnew;
    }
}
