package com.fecbo.companydeviceregister.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {

    private Integer departmentId;
    private String name;
    private String description;
    private Set<GroupResponse> groups;
}
