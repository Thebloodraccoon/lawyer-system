package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.repo.ClientJpaRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientJpaRepo clientJpaRepo;

    public List<Client> getAllClients() {
        return clientJpaRepo.findAll();
    }

    public Client getClient(Long id) {
        return clientJpaRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
    }

    public Client createClient(Client client) {
        return clientJpaRepo.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = clientJpaRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));

        if (updatedClient.getName() != null) {
            existingClient.setName(updatedClient.getName());
        }
        if (updatedClient.getEmail() != null) {
            existingClient.setEmail(updatedClient.getEmail());
        }
        if (updatedClient.getPhoneNum() != null) {
            existingClient.setPhoneNum(updatedClient.getPhoneNum());
        }

        return clientJpaRepo.save(existingClient);
    }

    public void deleteClient(Long id) {
        Client client = clientJpaRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
        clientJpaRepo.delete(client);
    }

    public Client findClientByEmail(String email) {
        Client clientByEmail = clientJpaRepo.findClientByEmail(email);

        return clientByEmail;
    }
}
