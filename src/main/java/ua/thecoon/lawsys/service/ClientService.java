package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.repo.ClientJpaRepo;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientJpaRepo clientJpaRepo;
    private final ConsultationJpaRepo consultationJpaRepo;

    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return clientJpaRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Client getClient(Long id) {
        return clientJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
    }

    @Transactional
    public Client createClient(Client client) {
        return clientJpaRepo.save(client);
    }

    @Transactional
    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = clientJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));

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

    @Transactional
    public boolean deleteClient(Long id) {
        clientJpaRepo.deleteById(id);

        return true;
    }

    @Transactional
    public boolean deleteClientConsultation(Long id) {
        consultationJpaRepo.deleteById(id);

        return true;
    }

    @Transactional(readOnly = true)
    public Client findClientByEmail(String email) {
        return clientJpaRepo.findClientByEmail(email);
    }
}