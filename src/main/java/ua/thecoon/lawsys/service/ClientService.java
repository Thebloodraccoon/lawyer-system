package ua.thecoon.lawsys.service;

import ua.thecoon.lawsys.model.dto.ClientDTO;
import ua.thecoon.lawsys.model.dto.ClientItemDTO;
import ua.thecoon.lawsys.model.entity.Client;

import java.util.List;

public interface ClientService {
    List<ClientItemDTO> getAllClients();
    ClientDTO getClient(Long id);
    ClientItemDTO getItemClient(Long id);
    ClientDTO createClient(Client clientDTO);
    ClientDTO updateClient(Long id, ClientDTO updatedClientDTO);
    boolean deleteClient(Long id);
    boolean deleteClientConsultation(Long id);
    Client findClientByEmail(String email);
}
