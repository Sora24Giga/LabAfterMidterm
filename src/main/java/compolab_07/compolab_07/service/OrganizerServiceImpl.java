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
    public Integer getEventSize() {
        return organizerDao.getEventSize();
    }

    @Override
    public Page<Organizer> getEvents(Integer pageSize, Integer page) {
        return organizerDao.getEvents(pageSize, page);
    }

    @Override
    public Organizer getEvent(Long id) {
        return organizerDao.getEvent(id);
    }

    @Override
    public Organizer save(Organizer event) {
        return organizerDao.save(event);
    }

}
