package org.bank.services;

import org.bank.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

public class BaseServiceImpl<E, ID> implements BaseService<E, ID> {

    @Autowired
    private BaseRepository<E, ID> baseRepository;

    @Override
    public E save(E entity) {
        return baseRepository.save(entity);
    }

    @Override
    public E findById(ID id) {
        return baseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);      //.or else throw();  (optional)

    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<E> findBySample(E entity) {
        return baseRepository.findAll(Example.of(entity, ExampleMatcher.matchingAll()));
    }

}
