package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.application.exception.RestApiError;
import com.fecbo.companydeviceregister.business.DepartmentManager;
import com.fecbo.companydeviceregister.controller.model.request.DepartmentRequest;
import com.fecbo.companydeviceregister.controller.model.response.DepartmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DepartmentResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) })
    })
    @Operation
    @PostMapping
    public DepartmentResponse addDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return manager.addDepartment(departmentRequest);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) })
    })
    @Operation
    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable("id") Integer id) {
        return manager.getDepartmentById(id);
    }
}
