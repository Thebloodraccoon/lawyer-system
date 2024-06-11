package ua.thecoon.lawsys.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.repo.ClientJpaRepo;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class ClientServiceIntegrationTest extends ServiceTestPatent {
    private ClientService clientService;

    @Mock
    private ClientJpaRepo clientJpaRepoMock;

    @Mock
    private ConsultationJpaRepo consultationJpaRepoMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        clientService = new ClientService(clientJpaRepoMock,
                consultationJpaRepoMock);
    }


    @Test
    public void testCreateClient() {
        when(clientJpaRepoMock.findById(1L)).thenReturn(Optional.ofNullable(testClients.get(0)));
        when(clientJpaRepoMock.save(any())).thenReturn(testClients.get(0));

        Client client = new Client();
        client.setId(0L);
        client.setName("John Doe");
        client.setEmail("john.doe@example.com");
        client.setPhoneNum("123456789");
        client.setPassword("password123");

        Client savedClient = clientService.createClient(client);

        Optional<Client> retrievedClient = clientJpaRepoMock.findById(savedClient.getId());

        assertTrue(retrievedClient.isPresent());
        assertEquals(client.getName(), retrievedClient.get().getName());
        assertEquals(client.getEmail(), retrievedClient.get().getEmail());
        assertEquals(client.getPhoneNum(), retrievedClient.get().getPhoneNum());
        assertEquals(client.getPassword(), retrievedClient.get().getPassword());
    }
}

