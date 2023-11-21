package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.UserEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {

    @CacheEvict(cacheNames = "UserServiceImpl_findAll")
    @Override
    public UserEntity save(UserEntity entity) {
        return super.save(entity);
    }

    @Cacheable(cacheNames = "UserServiceImpl_findAll")
    @Override
    public List<UserEntity> findAll() {
        return super.findAll();
    }
}
