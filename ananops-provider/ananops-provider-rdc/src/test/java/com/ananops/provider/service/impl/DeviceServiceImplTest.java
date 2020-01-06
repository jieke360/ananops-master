package com.ananops.provider.service.impl;

import com.ananops.provider.model.domain.Device;
import com.ananops.provider.service.DeviceService;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceImplTest {
    
    @Autowired
    DeviceService deviceService;
    
    @Test
    public void getAllDevicesSelective() {
        Device device = deviceService.getDeviceById(1L);
        Assert.assertTrue(device != null);
    }
    
    @Test
    public void getDeviceById() {
    }
}