package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Operation
    @GetMapping("/{id}")
    public WorkerResponse getWorkerById(@PathVariable("id") Integer id) {
        return new WorkerResponse();
    }
}
