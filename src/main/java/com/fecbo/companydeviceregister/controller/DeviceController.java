package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.business.DeviceManager;
import com.fecbo.companydeviceregister.controller.model.request.DeviceRequest;
import com.fecbo.companydeviceregister.controller.model.response.DeviceResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceManager manager;

    @Operation
    @PostMapping
    public DeviceResponse addDevice(@RequestBody DeviceRequest deviceRequest) {
        return manager.addDevice(deviceRequest);
    }

    @Operation
    @GetMapping("/{id}")
    public DeviceResponse getDeviceById(@PathVariable("id") Integer id) {
        return manager.getDeviceById(id);
    }

    @Operation
    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable("id") Integer id) {
        manager.deleteDevice(id);
    }
}
