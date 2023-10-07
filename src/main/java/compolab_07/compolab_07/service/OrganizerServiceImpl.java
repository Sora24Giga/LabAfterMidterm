package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import compolab_07.compolab_07.dao.OrganizerDao;
import compolab_07.compolab_07.entity.Organizer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizerDao organizerDao;

    @Override
    public Integer getOrganizerSize() {
        return organizerDao.getOrganizerSize();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizerDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerDao.getOrganizer(id);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizerDao.save(organizer);
    }
}