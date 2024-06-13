package ua.thecoon.lawsys.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.lawsys.model.dto.ClientDTO;
import ua.thecoon.lawsys.model.dto.ClientItemDTO;
import ua.thecoon.lawsys.model.entity.Client;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientDTO toDto(Client client);
    Client toEntity(ClientDTO clientDTO);

    ClientItemDTO toItemDto(Client client);
    Client toItemEntity(ClientItemDTO clientItemDTO);
}
