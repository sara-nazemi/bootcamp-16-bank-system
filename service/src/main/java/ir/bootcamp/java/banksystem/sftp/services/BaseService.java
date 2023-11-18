package ir.bootcamp.java.banksystem.sftp.services;

import java.util.List;

public interface BaseService<E, ID> {

    E save(E entity);

    E findById(ID id);

    void deleteById(ID id);

    List<E> findAll();

    List<E> findBySample(E entity);

}
