package com.fecbo.companydeviceregister.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeviceResponse implements Serializable {

    private Integer deviceId;
    private Integer workerId;
    private String name;
    private String description;
    private LocalDateTime timeOfRegistration;
}
