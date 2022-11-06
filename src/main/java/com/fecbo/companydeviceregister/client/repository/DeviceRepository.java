package com.fecbo.companydeviceregister.client.repository;

import com.fecbo.companydeviceregister.client.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
