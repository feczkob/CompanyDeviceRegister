package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.client.entity.Device;
import com.fecbo.companydeviceregister.client.repository.DeviceRepository;
import com.fecbo.companydeviceregister.controller.model.request.DeviceRequest;
import com.fecbo.companydeviceregister.controller.model.response.DeviceResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DeviceManager extends Manager {

    private final DeviceRepository deviceRepository;
    private final ModelMapper mapper;

    public DeviceResponse addDevice(DeviceRequest deviceRequest) {
//        Worker worker = load(deviceRequest.getWorkerId(), workerRepository);
        Device device = mapper.map(deviceRequest, Device.class);
//        device.setWorker(worker);
        device.setTimeOfRegistration(LocalDateTime.now());
        Device saved = deviceRepository.save(device);
        return mapper.map(saved, DeviceResponse.class);
    }

    public DeviceResponse getDeviceById(Integer id) {
        Device device = load(id, deviceRepository);
        return mapper.map(device, DeviceResponse.class);
    }

    public void deleteDevice(Integer id) {
        delete(id, deviceRepository);
    }


    public List<DeviceResponse> getAllByTimeOfRegistrationSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
        if(!checkIfFieldExists(property)) {
            throw new NoSuchFieldException("There is no field named \"" + property + "\".");
        }
        Pageable pageable = PageRequest.of(numOfPage, numOfElements, isAscending ? Sort.by(property).ascending() : Sort.by(property).descending());
        return deviceRepository.findAll(pageable).stream().map(d -> mapper.map(d, DeviceResponse.class)).collect(Collectors.toList());
    }

    private boolean checkIfFieldExists(String property) {
        List<Field> fields = List.of(Device.class.getDeclaredFields());
        Optional<Field> found = fields.stream().filter(field -> field.getName().equals(property)).findFirst();
        return found.isPresent();
    }
}
