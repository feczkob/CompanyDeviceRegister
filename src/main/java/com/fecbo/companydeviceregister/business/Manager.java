package com.fecbo.companydeviceregister.business;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class Manager {
    protected final ModelMapper mapper;

    <T, K extends JpaRepository> T load(Integer id, K repository) {
        Optional<T> found = repository.findById(id);
        if(found.isEmpty()) {
            throw new NoSuchElementException("Entity" + " with id " + id + " not found.");
        }
        return found.get();
    }

    <T, K extends JpaRepository> void delete(Integer id, K repository) {
        T loaded = load(id, repository);
        repository.delete(loaded);
    }

    <T> boolean checkIfFieldExists(String property, Class<T> clazz) {
        List<Field> fields = List.of(clazz.getDeclaredFields());
        Optional<Field> found = fields.stream().filter(field -> field.getName().equals(property)).findFirst();
        return found.isPresent();
    }

    <T, K extends JpaRepository> List<T> getAllSorted(Class<T> clazz, K repository,
                                                   String property, Integer numOfPage, Integer numOfElements,
                                                   Boolean isAscending) throws NoSuchFieldException {
        if(!checkIfFieldExists(property, clazz)) {
            throw new NoSuchFieldException("There is no field named \"" + property + "\" in class " + clazz.getName() + ".");
        }
        Pageable pageable = PageRequest.of(numOfPage, numOfElements, Boolean.TRUE.equals(isAscending) ? Sort.by(property).ascending() : Sort.by(property).descending());
        return repository.findAll(pageable).stream().map(d -> mapper.map(d, clazz)).toList();
    }
}
