package compolab_07.compolab_07.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import compolab_07.compolab_07.entity.Event;

public interface EventDao {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);
    Event save(Event event);

    Page<Event> getEvents(String name, Pageable page);


}