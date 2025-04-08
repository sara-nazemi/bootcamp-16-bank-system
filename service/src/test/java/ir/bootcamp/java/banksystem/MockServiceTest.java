package ir.bootcamp.java.banksystem;

import ir.bootcamp.java.banksystem.sftp.launcher.SpringLearningApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringLearningApplication.class)
@ExtendWith(MockitoExtension.class)
public class MockServiceTest {
}
