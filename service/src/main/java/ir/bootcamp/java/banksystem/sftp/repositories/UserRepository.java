package ir.bootcamp.java.banksystem.sftp.repositories;

import ir.bootcamp.java.banksystem.models.documents.models.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends BaseRepository<UserEntity, Long> {

    @Query("from UserEntity e where e.username = :username")
    UserEntity loadByUsername(@Param("username") String username);
}
