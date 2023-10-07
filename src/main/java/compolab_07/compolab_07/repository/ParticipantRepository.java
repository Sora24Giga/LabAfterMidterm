package compolab_07.compolab_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import compolab_07.compolab_07.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
