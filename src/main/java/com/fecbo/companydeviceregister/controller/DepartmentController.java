package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.business.DepartmentManager;
import com.fecbo.companydeviceregister.controller.model.request.DepartmentRequest;
import com.fecbo.companydeviceregister.controller.model.response.DepartmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentManager manager;

    @Operation
    @PostMapping
    public DepartmentResponse addDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return manager.addDepartment(departmentRequest);
    }

    @Operation
    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable("id") Integer id) {
        return manager.getDepartmentById(id);
    }
}
