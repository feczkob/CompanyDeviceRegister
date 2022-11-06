package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.client.entity.Group;
import com.fecbo.companydeviceregister.client.entity.Worker;
import com.fecbo.companydeviceregister.client.repository.GroupRepository;
import com.fecbo.companydeviceregister.client.repository.WorkerRepository;
import com.fecbo.companydeviceregister.controller.model.request.WorkerRequest;
import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkerManager {

    private final WorkerRepository workerRepository;
    private final GroupRepository groupRepository;
    private final ModelMapper mapper;

    public WorkerResponse getWorkerById(Integer id) {
        Worker worker = load(id, workerRepository);
        return mapper.map(worker, WorkerResponse.class);
    }

    public WorkerResponse addWorker(WorkerRequest workerRequest) {
        Group group = load(workerRequest.getGroupId(), groupRepository);
        Worker worker = mapper.map(workerRequest, Worker.class);
        worker.setGroup(group);
        Worker saved = workerRepository.save(worker);
        return mapper.map(saved, WorkerResponse.class);
    }

    public WorkerResponse modifyWorker(Integer id, WorkerRequest workerRequest) {
        Worker worker = load(id, workerRepository);
        Group group = load(workerRequest.getGroupId(), groupRepository);
        Worker toBeModified = mapper.map(workerRequest, Worker.class);
        toBeModified.setWorkerId(id);
        toBeModified.setGroup(group);
        return mapper.map(workerRepository.save(toBeModified), WorkerResponse.class);
    }

    private <T, K extends JpaRepository> T load(Integer id, K repository) {
        Optional<T> found = repository.findById(id);
        if(found.isEmpty()) {
            throw new NoSuchElementException(found.getClass() + " with id " + id + " not found.");
        }
        return found.get();
    }

}
