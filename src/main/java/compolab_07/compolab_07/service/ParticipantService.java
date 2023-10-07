package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;

import compolab_07.compolab_07.entity.Participant;


public interface ParticipantService {
    Integer getParticipantSize();

    Page<Participant> getParticipants(Integer pageSize, Integer page);

    Participant getParticipant(Long id); 

    Participant save(Participant participant);
}