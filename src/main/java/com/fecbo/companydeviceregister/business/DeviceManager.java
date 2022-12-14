package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.application.exception.MissingEntityException;
import com.fecbo.companydeviceregister.client.entity.Device;
import com.fecbo.companydeviceregister.client.repository.DeviceRepository;
import com.fecbo.companydeviceregister.client.repository.WorkerRepository;
import com.fecbo.companydeviceregister.controller.model.request.DeviceRequest;
import com.fecbo.companydeviceregister.controller.model.response.DeviceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DeviceManager extends Manager {

    private final DeviceRepository deviceRepository;
    private final WorkerRepository workerRepository;

    public DeviceManager(ModelMapper mapper, DeviceRepository deviceRepository, WorkerRepository workerRepository) {
        super(mapper);
        this.deviceRepository = deviceRepository;
        this.workerRepository = workerRepository;
    }

    public DeviceResponse addDevice(DeviceRequest deviceRequest) throws MissingEntityException {
        Device device = mapper.map(deviceRequest, Device.class);
        device.setTimeOfRegistration(LocalDateTime.now());
        load(deviceRequest.getWorkerId(), workerRepository);
        Device saved = deviceRepository.save(device);
        return mapper.map(saved, DeviceResponse.class);
    }

    public DeviceResponse getDeviceById(Integer id) throws MissingEntityException {
        Device device = load(id, deviceRepository);
        return mapper.map(device, DeviceResponse.class);
    }

    public void deleteDevice(Integer id) throws MissingEntityException {
        delete(id, deviceRepository);
    }


//    public List<DeviceResponse> getAllSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
//        if(!checkIfFieldExists(property)) {
//            throw new NoSuchFieldException("There is no field named \"" + property + "\".");
//        }
//        Pageable pageable = PageRequest.of(numOfPage, numOfElements, Boolean.TRUE.equals(isAscending) ? Sort.by(property).ascending() : Sort.by(property).descending());
//        return deviceRepository.findAll(pageable).stream().map(d -> mapper.map(d, DeviceResponse.class)).toList();
//    }
//
//    private boolean checkIfFieldExists(String property) {
//        List<Field> fields = List.of(Device.class.getDeclaredFields());
//        Optional<Field> found = fields.stream().filter(field -> field.getName().equals(property)).findFirst();
//        return found.isPresent();
//    }

    public List<DeviceResponse> getAllSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
        return getAllSorted(DeviceResponse.class, deviceRepository, property, numOfPage, numOfElements, isAscending);
    }
}
