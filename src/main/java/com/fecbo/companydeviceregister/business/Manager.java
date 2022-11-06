package com.fecbo.companydeviceregister.business;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class Manager {

    <T, K extends JpaRepository> T load(Integer id, K repository) {
        Optional<T> found = repository.findById(id);
        if(found.isEmpty()) {
            throw new NoSuchElementException(found.getClass() + " with id " + id + " not found.");
        }
        return found.get();
    }

    <T, K extends JpaRepository> void delete(Integer id, K repository) {
        T loaded = load(id, repository);
        repository.delete(loaded);
    }
}
