package compolab_07.compolab_07.service;

import org.springframework.data.domain.Page;

import compolab_07.compolab_07.entity.Organizer;


public interface OrganizerService {
    Integer getOrganizerSize();

    Page<Organizer> getOrganizers(Integer pageSize, Integer page);

    Organizer getOrganizer(Long id);

    Organizer save(Organizer organizer);
}