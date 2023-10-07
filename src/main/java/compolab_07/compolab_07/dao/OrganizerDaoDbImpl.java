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
    final OrganizerRepository organizerRepository;

    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        if (pageSize != null && page != null) {
            return organizerRepository.findAll(PageRequest.of(page - 1, pageSize));
        }
        return organizerRepository.findAll(PageRequest.of(0, getOrganizerSize()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer save(Organizer Organizer) {
        return organizerRepository.save(Organizer);
    }

}
