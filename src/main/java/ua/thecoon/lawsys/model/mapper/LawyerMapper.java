package ua.thecoon.lawsys.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.lawsys.model.dto.LawyerDTO;
import ua.thecoon.lawsys.model.dto.LawyerItemDTO;
import ua.thecoon.lawsys.model.entity.Lawyer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LawyerMapper {
    LawyerDTO toDto(Lawyer lawyer);
    Lawyer toEntity(LawyerDTO lawyerDTO);

    LawyerItemDTO toItemDto(Lawyer lawyer);
    Lawyer toItemEntity(LawyerItemDTO lawyer);
}