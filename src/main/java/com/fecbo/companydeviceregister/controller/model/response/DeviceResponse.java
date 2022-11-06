package com.fecbo.companydeviceregister.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {

    private Integer deviceId;
    private Integer workerId;
    private String name;
    private String description;
}
