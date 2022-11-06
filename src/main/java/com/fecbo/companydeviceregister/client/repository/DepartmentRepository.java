package com.fecbo.companydeviceregister.client.repository;

import com.fecbo.companydeviceregister.client.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
