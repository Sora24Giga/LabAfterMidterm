package compolab_07.compolab_07.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class OrganizerDaoDbImpl implements OrganizerDao {
    final OrganizerRepository OrganizerRepository;

    @Override
    public Integer getEventSize() {
        return Math.toIntExact(OrganizerRepository.count());
    }

    @Override
    public Page<Organizer> getEvents(Integer pageSize, Integer page) {
        return OrganizerRepository.findAll(PageRequest.of(page - 1, pageSize));

    }

    @Override
    public Organizer getEvent(Long id) {
        return OrganizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer save(Organizer event) {
        return OrganizerRepository.save(event);
    }

}
