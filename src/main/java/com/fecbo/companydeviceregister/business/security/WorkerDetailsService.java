package com.fecbo.companydeviceregister.business.security;

import com.fecbo.companydeviceregister.client.entity.Worker;
import com.fecbo.companydeviceregister.client.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkerDetailsService implements UserDetailsService {

    private final WorkerRepository workerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Worker worker = workerRepository.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Worker with username %s not found", username)
                ));

        return User.builder()
                .username(worker.getUsername())
                .password(worker.getPassword())
                .authorities(worker.getRole())
                .build();
    }
}
