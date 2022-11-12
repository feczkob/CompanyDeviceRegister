package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.client.entity.Worker;
import com.fecbo.companydeviceregister.client.repository.WorkerRepository;
import com.fecbo.companydeviceregister.controller.model.request.WorkerRequest;
import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerManager extends Manager {

    private final WorkerRepository workerRepository;

    public WorkerManager(ModelMapper mapper, WorkerRepository workerRepository) {
        super(mapper);
        this.workerRepository = workerRepository;
    }

    public WorkerResponse addWorker(WorkerRequest workerRequest) {
        Worker worker = mapper.map(workerRequest, Worker.class);
        Worker saved = workerRepository.save(worker);
        return mapper.map(saved, WorkerResponse.class);
    }

    public WorkerResponse getWorkerById(Integer id) {
        Worker worker = load(id, workerRepository);
        return mapper.map(worker, WorkerResponse.class);
    }

    public WorkerResponse modifyWorker(Integer id, WorkerRequest workerRequest) {
        Worker worker = load(id, workerRepository);
        Worker toBeModified = mapper.map(workerRequest, Worker.class);
        toBeModified.setWorkerId(worker.getWorkerId());
        return mapper.map(workerRepository.save(toBeModified), WorkerResponse.class);
    }

    public void deleteWorker(Integer id) {
        delete(id, workerRepository);
    }

    public List<WorkerResponse> getAllSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
        return getAllSorted(WorkerResponse.class, workerRepository, property, numOfPage, numOfElements, isAscending);
    }

}
