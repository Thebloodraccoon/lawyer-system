package ua.thecoon.lawsys.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.lawsys.model.dto.ConsultationDTO;
import ua.thecoon.lawsys.model.entity.Consultation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ClientMapper.class, LawyerMapper.class})
public interface ConsultationMapper {
    ConsultationDTO toDto(Consultation consultation);
    Consultation toEntity(ConsultationDTO consultationDTO);
}
