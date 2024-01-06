package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.models.UserEntity;
import ir.bootcamp.java.banksystem.sftp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;

    //@CacheEvict(cacheNames = "UserServiceImpl_findAll")
    @Override
    public UserEntity save(UserEntity entity) {
        entity.setPassword(bcryptEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }

    //@Cacheable(cacheNames = "UserServiceImpl_findAll")
    @Override
    public List<UserEntity> findAll() {
        return super.findAll();
    }

    @Override
    public UserEntity loadByUsername(String username) {
        return userRepository.loadByUsername(username);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("sara"));
    }

}
