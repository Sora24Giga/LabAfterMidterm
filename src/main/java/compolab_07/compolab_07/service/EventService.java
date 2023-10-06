package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;

import compolab_07.compolab_07.entity.Event;

public interface EventService {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);

    Event save(Event event);

}