package compolab_07.compolab_07.dao;

import org.springframework.data.domain.Page;

import compolab_07.compolab_07.entity.Participant;

public interface ParticipantDao {
    Integer getParticipantSize();

    Page<Participant> getParticipants(Integer pageSize, Integer page);

    Participant getParticipant(Long id);

    Participant save(Participant event);
}
