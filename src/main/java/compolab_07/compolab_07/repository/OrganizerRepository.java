package compolab_07.compolab_07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import compolab_07.compolab_07.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer,Long> {
    List<Organizer> findAll();
}
