package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.business.WorkerManager;
import com.fecbo.companydeviceregister.controller.model.request.WorkerRequest;
import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerManager manager;

    @Operation
    @GetMapping("/{id}")
    public WorkerResponse getWorkerById(@PathVariable("id") Integer id) {
        return manager.getWorkerById(id);
    }

    @Operation
    @PostMapping
    public WorkerResponse addWorker(@RequestBody WorkerRequest workerRequest) {
        return manager.addWorker(workerRequest);
    }

    @Operation
    @PutMapping("/{id}")
    public WorkerResponse modifyWorker(@PathVariable("id") Integer id,
                                       @RequestBody WorkerRequest workerRequest) {
        return manager.modifyWorker(id, workerRequest);
    }
}
