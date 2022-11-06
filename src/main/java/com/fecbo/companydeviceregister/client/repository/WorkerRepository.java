package com.fecbo.companydeviceregister.client.repository;

import com.fecbo.companydeviceregister.client.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
