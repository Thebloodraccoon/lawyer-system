package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.dto.ClientDTO;
import ua.thecoon.lawsys.model.dto.ClientItemDTO;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.mapper.ClientMapper;
import ua.thecoon.lawsys.repo.ClientJpaRepo;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientJpaRepo clientJpaRepo;
    private final ConsultationService consultationService;
    private final ClientMapper clientMapper;

    @Transactional(readOnly = true)
    public List<ClientItemDTO> getAllClients() {
        List<Client> all = clientJpaRepo.findAll();

        return all.stream()
                .map(clientMapper::toItemDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ClientDTO getClient(Long id) {
        Client client = getClientById(id);

        return clientMapper.toDto(client);
    }

    @Transactional(readOnly = true)
    public ClientItemDTO getItemClient(Long id) {
        Client client = getClientById(id);

        return clientMapper.toItemDto(client);
    }

    @Transactional
    public ClientDTO createClient(Client client) {
        Client save = clientJpaRepo.save(client);

        return clientMapper.toDto(save);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO updatedClient) {
        Client existingClient = getClientById(id);

        updateClientFields(existingClient, updatedClient);

        Client save = clientJpaRepo.save(existingClient);

        return clientMapper.toDto(save);
    }

    @Transactional
    public boolean deleteClient(Long id) {
        clientJpaRepo.deleteById(id);

        return true;
    }

    @Transactional
    public boolean deleteClientConsultation(Long id) {
        return consultationService.deleteConsultation(id);
    }

    @Transactional(readOnly = true)
    public Client findClientByEmail(String email) {
        return clientJpaRepo.findClientByEmail(email);
    }

    private Client getClientById(Long id) {
        return clientJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
    }

    private void updateClientFields(Client existingClient, ClientDTO updatedClient) {
        if (updatedClient.getName() != null) {
            existingClient.setName(updatedClient.getName());
        }
        if (updatedClient.getEmail() != null) {
            existingClient.setEmail(updatedClient.getEmail());
        }
        if (updatedClient.getPhoneNum() != null) {
            existingClient.setPhoneNum(updatedClient.getPhoneNum());
        }
    }
}