package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.sftp.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

public class BaseServiceImpl<E, ID> implements BaseService<E, ID> {

    @Autowired(required = false)
    private BaseRepository<E, ID> baseRepository;

    @Override
    public E save(E entity) throws InterruptedException {
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
