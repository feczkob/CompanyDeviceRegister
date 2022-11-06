package com.fecbo.companydeviceregister.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRequest {

    @NotNull(message = "error.'${validatedValue}'.empty")
    private Integer workerId;
    @NotBlank(message = "error.'${validatedValue}'.empty")
    private String name;
    @NotBlank(message = "error.'${validatedValue}'.empty")
    private String description;
}
