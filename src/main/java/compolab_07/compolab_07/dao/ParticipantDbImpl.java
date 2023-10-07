package compolab_07.compolab_07.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import compolab_07.compolab_07.entity.Participant;
import compolab_07.compolab_07.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class ParticipantDbImpl implements ParticipantDao {
    final ParticipantRepository ParticipantRepository;

    @Override
    public Integer getParticipantSize() {
        return Math.toIntExact(ParticipantRepository.count());
    }

    @Override
    public Page<Participant> getParticipants(Integer pageSize, Integer page) {
        if (pageSize != null && page != null) {
            return ParticipantRepository.findAll(PageRequest.of(page - 1, pageSize));
        }
        return ParticipantRepository.findAll(PageRequest.of(0, getParticipantSize()));
    }

    @Override
    public Participant getParticipant(Long id) {
        return ParticipantRepository.findById(id).orElse(null);
    }

    @Override
    public Participant save(Participant participant) {
        return ParticipantRepository.save(participant);
    }

}