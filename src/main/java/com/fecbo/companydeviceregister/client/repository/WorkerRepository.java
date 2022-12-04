package com.fecbo.companydeviceregister.client.repository;

import com.fecbo.companydeviceregister.client.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    Optional<Worker> findFirstByUsername(String username);
}
