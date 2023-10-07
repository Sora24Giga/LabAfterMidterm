package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import compolab_07.compolab_07.dao.EventDao;
import compolab_07.compolab_07.dao.OrganizerDao;
import compolab_07.compolab_07.entity.Event;
import compolab_07.compolab_07.entity.Organizer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    final EventDao eventDao;

    final OrganizerDao organizerDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        Organizer organizer = organizerDao.getOrganizer(event.getOrganizer().getId());
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);

        return eventDao.save(event);
    }

}
