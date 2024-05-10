package ua.thecoon.lawsys.service;

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
        Client byId = clientJpaRepo.findById(id).get();

        return byId;
    }
}
