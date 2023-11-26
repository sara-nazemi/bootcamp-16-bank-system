package ir.bootcamp.java.banksystem.repositoties;

import ir.bootcamp.java.banksystem.models.documents.models.UserEntity;
import ir.bootcamp.java.banksystem.sftp.launcher.SpringLearningApplication;
import ir.bootcamp.java.banksystem.sftp.repositories.UserRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootTest(classes = {SpringLearningApplication.class})
@ComponentScan("ir.bootcamp.java.banksystem")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("f@gmail.com");
        userEntity.setTelephone("091284");
        this.userRepository.save(userEntity);
    }

    @Test
    public void testInsertionOfUserRepository() {
        List<UserEntity> all = this.userRepository.findAll();
        MatcherAssert.assertThat(all, IsCollectionWithSize.hasSize(1));

    }
}
