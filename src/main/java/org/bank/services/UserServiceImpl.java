package org.bank.services;

import org.bank.models.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {

    @Override
    public UserEntity save(UserEntity entity) {
//        if (entity.getPersonEntity() != null && entity.getPersonEntity().getId() == null) {
//            // delete relation (FK)
//            entity.setPersonEntity(null);
//        }
        return super.save(entity);
    }
}
