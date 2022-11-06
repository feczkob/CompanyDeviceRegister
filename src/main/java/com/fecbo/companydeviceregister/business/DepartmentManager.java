package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.client.entity.Department;
import com.fecbo.companydeviceregister.client.repository.DepartmentRepository;
import com.fecbo.companydeviceregister.controller.model.request.DepartmentRequest;
import com.fecbo.companydeviceregister.controller.model.response.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentManager extends Manager {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;


    public DepartmentResponse addDepartment(DepartmentRequest departmentRequest) {
        Department department = mapper.map(departmentRequest, Department.class);
        Department saved = departmentRepository.save(department);
        return mapper.map(saved, DepartmentResponse.class);
    }

    public DepartmentResponse getDepartmentById(Integer id) {
        Department department = load(id, departmentRepository);
        return mapper.map(department, DepartmentResponse.class);
    }
}
