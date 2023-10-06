package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;

import compolab_07.compolab_07.entity.Organizer;

public interface OrganizerService {
    Integer getEventSize();

    Page<Organizer> getEvents(Integer pageSize, Integer page);

    Organizer getEvent(Long id);

    Organizer save(Organizer event);

}