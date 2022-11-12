package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.application.exception.RestApiError;
import com.fecbo.companydeviceregister.business.GroupManager;
import com.fecbo.companydeviceregister.controller.model.request.GroupRequest;
import com.fecbo.companydeviceregister.controller.model.response.GroupResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupManager manager;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GroupResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) })
    })
    @Operation
    @PostMapping
    public GroupResponse addGroup(@RequestBody GroupRequest groupRequest) {
        return manager.addGroup(groupRequest);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GroupResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class)) })
    })
    @Operation
    @GetMapping("/{id}")
    public GroupResponse getGroupById(@PathVariable("id") Integer id) {
        return manager.getGroupById(id);
    }

    @Operation
    @GetMapping("/getAll")
    public List<GroupResponse> getAllGroupsSorted(
            @RequestParam(value = "property", defaultValue = "name") String property,
            @Parameter(description = "Starts with value of 0.")
            @RequestParam(value = "numOfPage", defaultValue = "0") Integer numOfPage,
            @RequestParam(value = "numOfElements", defaultValue = "5") Integer numOfElements,
            @RequestParam(value = "isAscending", defaultValue = "true") Boolean isAscending
    ) throws NoSuchFieldException {
        return manager.getAllSorted(property, numOfPage, numOfElements, isAscending);
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
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Integer id) {
        manager.deleteGroup(id);
    }
}
