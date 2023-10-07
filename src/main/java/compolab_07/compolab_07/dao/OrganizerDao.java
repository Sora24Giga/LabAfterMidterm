package compolab_07.compolab_07.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import compolab_07.compolab_07.entity.Organizer;

public interface OrganizerDao {
    Integer getOrganizerSize();

    Page<Organizer> getOrganizers(Integer pageSize, Integer page);

    Organizer getOrganizer(Long id);

    Organizer save(Organizer event);
}
