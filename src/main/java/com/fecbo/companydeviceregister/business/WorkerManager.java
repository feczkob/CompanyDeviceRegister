package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.application.exception.MissingEntityException;
import com.fecbo.companydeviceregister.client.entity.Worker;
import com.fecbo.companydeviceregister.client.repository.GroupRepository;
import com.fecbo.companydeviceregister.client.repository.WorkerRepository;
import com.fecbo.companydeviceregister.controller.model.request.WorkerRequest;
import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerManager extends Manager {

    private final WorkerRepository workerRepository;
    private final GroupRepository groupRepository;
    private final PasswordEncoder encoder;

    public WorkerManager(ModelMapper mapper, WorkerRepository workerRepository, GroupRepository groupRepository, PasswordEncoder encoder) {
        super(mapper);
        this.workerRepository = workerRepository;
        this.groupRepository = groupRepository;
        this.encoder = encoder;
    }

    public WorkerResponse addWorker(WorkerRequest workerRequest) throws MissingEntityException {
        Worker worker = mapper.map(workerRequest, Worker.class);
        load(worker.getGroupId(), groupRepository);

        worker.setPassword(encoder.encode(workerRequest.getPassword()));
        worker.setRole("ROLE_USER");
        worker.setUsername(workerRequest.getName().toLowerCase());

        Worker saved = workerRepository.save(worker);
        return mapper.map(saved, WorkerResponse.class);
    }

    public WorkerResponse getWorkerById(Integer id) throws MissingEntityException {
        Worker worker = load(id, workerRepository);
        return mapper.map(worker, WorkerResponse.class);
    }

    public WorkerResponse modifyWorker(Integer id, WorkerRequest workerRequest) throws MissingEntityException {
        Worker worker = load(id, workerRepository);
        Worker toBeModified = mapper.map(workerRequest, Worker.class);
        toBeModified.setWorkerId(worker.getWorkerId());

        // * so that it won't fail
        toBeModified.setPassword(encoder.encode(workerRequest.getPassword()));
        toBeModified.setRole("ROLE_USER");
        toBeModified.setUsername(workerRequest.getName().toLowerCase());

        return mapper.map(workerRepository.save(toBeModified), WorkerResponse.class);
    }

    public void deleteWorker(Integer id) throws MissingEntityException {
        delete(id, workerRepository);
    }

    public List<WorkerResponse> getAllSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
        return getAllSorted(WorkerResponse.class, workerRepository, property, numOfPage, numOfElements, isAscending);
    }

}
