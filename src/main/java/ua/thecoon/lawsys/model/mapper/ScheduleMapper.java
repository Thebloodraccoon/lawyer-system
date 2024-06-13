package ua.thecoon.lawsys.model.mapper;

import org.mapstruct.Mapper;
import ua.thecoon.lawsys.model.dto.ScheduleDTO;
import ua.thecoon.lawsys.model.entity.Schedule;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleDTO toDto(Schedule schedule);
    Schedule toEntity(ScheduleDTO scheduleDTO);
}