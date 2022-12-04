package com.fecbo.companydeviceregister.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkerResponse implements Serializable {

    private Integer workerId;
    private Integer groupId;
    private String name;
    private String details;
    private Set<DeviceResponse> devices;
}
