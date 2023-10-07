package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import compolab_07.compolab_07.dao.OrganizerDao;
import compolab_07.compolab_07.dao.ParticipantDao;
import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.entity.Participant;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantDao participantDao;

    @Override
    public Integer getParticipantSize() {
        return participantDao.getParticipantSize();
    }

    @Override
    public Page<Participant> getParticipants(Integer pageSize, Integer page) {
        return participantDao.getParticipants(pageSize, page);
    }

    @Override
    public Participant getParticipant(Long id) {
        return participantDao.getParticipant(id);
    }

    @Override
    public Participant save(Participant participant) {
        return participantDao.save(participant);
    }
}