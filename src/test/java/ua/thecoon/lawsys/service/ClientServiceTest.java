package ua.thecoon.lawsys.service;


import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.repo.ClientJpaRepo;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {
    private ClientService clientService;

    @Mock
    private ClientJpaRepo clientJpaRepoMock;

    @Mock
    private ConsultationJpaRepo consultationJpaRepoMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        clientService = new ClientService(clientJpaRepoMock, consultationJpaRepoMock);
    }

    @Test
    public void testGetAllClients() {
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(clientJpaRepoMock.findAll()).thenReturn(clients);

        List<Client> result = clientService.getAllClients();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetClient() {
        Client client = new Client();
        client.setId(1L);
        when(clientJpaRepoMock.findById(1L)).thenReturn(Optional.of(client));

        Client result = clientService.getClient(1L);
        assertEquals(1L, result.getId().longValue());
    }

    @Test
    public void testGetClientNotFound() {
        when(clientJpaRepoMock.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clientService.getClient(1L));
    }

    @Test
    public void testCreateClient() {
        Client client = new Client();
        client.setName("Test");

        when(clientJpaRepoMock.save(client)).thenReturn(client);

        Client result = clientService.createClient(client);
        assertEquals("Test", result.getName());
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Original");
        Client updatedClient = new Client();
        updatedClient.setName("Updated");

        when(clientJpaRepoMock.findById(1L)).thenReturn(Optional.of(client));
        when(clientJpaRepoMock.save(client)).thenReturn(client);

        Client result = clientService.updateClient(1L, updatedClient);
        assertEquals("Updated", result.getName());
    }

    @Test
    public void testDeleteClient() {
        doNothing().when(clientJpaRepoMock).deleteById(1L);

        boolean result = clientService.deleteClient(1L);
        assertTrue(result);
    }

    @Test
    public void testDeleteClientConsultation() {
        doNothing().when(consultationJpaRepoMock).deleteById(1L);

        boolean result = clientService.deleteClientConsultation(1L);
        assertTrue(result);
    }

    @Test
    public void testFindClientByEmail() {
        Client client = new Client();
        client.setEmail("test@example.com");
        when(clientJpaRepoMock.findClientByEmail("test@example.com")).thenReturn(client);

        Client result = clientService.findClientByEmail("test@example.com");
        assertEquals("test@example.com", result.getEmail());
    }
}