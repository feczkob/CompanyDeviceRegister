package com.fecbo.companydeviceregister.business;

import com.fecbo.companydeviceregister.client.entity.Group;
import com.fecbo.companydeviceregister.client.repository.GroupRepository;
import com.fecbo.companydeviceregister.controller.model.request.GroupRequest;
import com.fecbo.companydeviceregister.controller.model.response.GroupResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupManager extends Manager {

    private final GroupRepository groupRepository;

    public GroupManager(ModelMapper mapper, GroupRepository groupRepository) {
        super(mapper);
        this.groupRepository = groupRepository;
    }

    public GroupResponse addGroup(GroupRequest groupRequest) {
        Group group = mapper.map(groupRequest, Group.class);
        Group saved = groupRepository.save(group);
        return mapper.map(saved, GroupResponse.class);
    }

    public GroupResponse getGroupById(Integer id) {
        Group group = load(id, groupRepository);
        return mapper.map(group, GroupResponse.class);
    }

    public void deleteGroup(Integer id) {
        delete(id, groupRepository);
    }

    public List<GroupResponse> getAllSorted(String property, Integer numOfPage, Integer numOfElements, Boolean isAscending) throws NoSuchFieldException {
        return getAllSorted(GroupResponse.class, groupRepository, property, numOfPage, numOfElements, isAscending);
    }
}
