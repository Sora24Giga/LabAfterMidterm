package compolab_07.compolab_07.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import compolab_07.compolab_07.entity.Event;
import compolab_07.compolab_07.entity.EventDTO;
import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.entity.OrganizerDTO;
import compolab_07.compolab_07.entity.Participant;
import compolab_07.compolab_07.entity.ParticipantDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);

    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDTO getParticipantDTO(Participant participant);

    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);
}
