package ua.thecoon.lawsys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.lawsys.repo.ClientJpaRepo;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientJpaRepo clientJpaRepo;
}
