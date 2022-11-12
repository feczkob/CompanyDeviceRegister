package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.application.exception.MissingEntityException;
import com.fecbo.companydeviceregister.client.entity.Group;
import com.fecbo.companydeviceregister.client.repository.DepartmentRepository;
import com.fecbo.companydeviceregister.client.repository.GroupRepository;
import com.fecbo.companydeviceregister.controller.model.request.GroupRequest;
import com.fecbo.companydeviceregister.controller.model.response.GroupResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupManager extends Manager {

    private final GroupRepository groupRepository;
    private final DepartmentRepository departmentRepository;

    public GroupManager(ModelMapper mapper, GroupRepository groupRepository, DepartmentRepository departmentRepository) {
        super(mapper);
        this.groupRepository = groupRepository;
        this.departmentRepository = departmentRepository;
    }

    public GroupResponse addGroup(GroupRequest groupRequest) throws MissingEntityException {
        Group group = mapper.map(groupRequest, Group.class);
        load(group.getDepartmentId(), departmentRepository);
        Group saved = groupRepository.save(group);
        return mapper.map(saved, GroupResponse.class);
    }

    public GroupResponse getGroupById(Integer id) throws MissingEntityException {
        Group group = load(id, groupRepository);
        return mapper.map(group, GroupResponse.class);
    }

    public void deleteGroup(Integer id) throws MissingEntityException {
        delete(id, groupRepository);
    }

    public List<GroupResponse> getAllSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
        return getAllSorted(GroupResponse.class, groupRepository, property, numOfPage, numOfElements, isAscending);
    }
}
