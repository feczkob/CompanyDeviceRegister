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
public class WorkerResponse {

    private Integer workerId;
    private Integer groupId;
    private String name;
    private String details;
    private Set<DeviceResponse> devices;
}
