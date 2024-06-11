package ua.thecoon.lawsys.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.thecoon.lawsys.config.ServiceTestConfig;
import ua.thecoon.lawsys.model.entity.Client;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
public class ServiceTestPatent {
    @Autowired
    protected ObjectMapper objectMapper;

    protected List<Client> testClients;

    @BeforeEach
    void setUpParent() {
        initClients();
    }

    private void initClients() {
        try(final InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("client-data.json");

        ) {

            testClients = objectMapper.readValue(inputStream, new TypeReference<List<Client>>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
