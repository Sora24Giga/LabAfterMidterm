package compolab_07.compolab_07.dao;

import compolab_07.compolab_07.entity.Organizer;
import org.springframework.data.domain.Page;


public interface OrganizerDao {
    Integer getEventSize();

    Page<Organizer> getEvents(Integer pageSize, Integer page);

    Organizer getEvent(Long id);
    Organizer save(Organizer event);
}