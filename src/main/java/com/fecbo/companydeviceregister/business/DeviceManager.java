package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.client.entity.Device;
import com.fecbo.companydeviceregister.client.entity.Worker;
import com.fecbo.companydeviceregister.client.repository.DeviceRepository;
import com.fecbo.companydeviceregister.client.repository.WorkerRepository;
import com.fecbo.companydeviceregister.controller.model.request.DeviceRequest;
import com.fecbo.companydeviceregister.controller.model.response.DeviceResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceManager extends Manager {

    private final WorkerRepository workerRepository;
    private final DeviceRepository deviceRepository;
    private final ModelMapper mapper;

    public DeviceResponse addDevice(DeviceRequest deviceRequest) {
        Worker worker = load(deviceRequest.getWorkerId(), workerRepository);
        Device device = mapper.map(deviceRequest, Device.class);
        device.setWorker(worker);
        Device saved = deviceRepository.save(device);
        DeviceResponse response = mapper.map(saved, DeviceResponse.class);
        response.setWorkerId(worker.getWorkerId());
        return response;
    }

    public DeviceResponse getDeviceById(Integer id) {
        Device device = load(id, deviceRepository);
        DeviceResponse response = mapper.map(device, DeviceResponse.class);
        response.setWorkerId(device.getWorker().getWorkerId());
        return response;
    }

    public void deleteDevice(Integer id) {
        delete(id, deviceRepository);
    }


}
