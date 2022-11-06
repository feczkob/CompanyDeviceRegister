package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.business.GroupManager;
import com.fecbo.companydeviceregister.controller.model.request.GroupRequest;
import com.fecbo.companydeviceregister.controller.model.response.GroupResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupManager manager;

    @Operation
    @PostMapping
    public GroupResponse addGroup(@RequestBody GroupRequest groupRequest) {
        return manager.addGroup(groupRequest);
    }

    @Operation
    @GetMapping("/{id}")
    public GroupResponse getGroupById(@PathVariable("id") Integer id) {
        return manager.getGroupById(id);
    }

    @Operation
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Integer id) {
        manager.deleteGroup(id);
    }
}
