package ir.bootcamp.java.banksystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class ConnectionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionTest.class);

    RestTemplate restTemplate = new RestTemplate();

    @Container
    static GenericContainer genericContainer = new GenericContainer(
            DockerImageName.parse("kennethreits/httpbin:latest"))
            .withExposedPorts(80);


    @Test
    @DisplayName("withFixedUrlShouldFail")
    public void test1() {

        String url = "http://localhost:80";

        LOGGER.info("URL : {}", url);


    }


}
